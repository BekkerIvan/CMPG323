package com.cmpg.nwu.accsystem.controller;

import com.cmpg.nwu.accsystem.orm.entity.MilesAccount;
import com.cmpg.nwu.accsystem.orm.entity.MilesSpent;
import com.cmpg.nwu.accsystem.orm.entity.Voucher;
import com.cmpg.nwu.accsystem.orm.repo.MilesAccountRepository;
import com.cmpg.nwu.accsystem.orm.repo.MilesSpentRepository;
import com.cmpg.nwu.accsystem.orm.repo.VoucherRepository;
import com.cmpg.nwu.accsystem.project_functions.ProjectFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;

@RestController
public class VoucherController {
    @Autowired
    private MilesAccountRepository MilesAccountRepository;

    @Autowired
    private VoucherRepository VoucherRepository;

    @Autowired
    private MilesSpentRepository MileSpentRepository;

    @GetMapping("/{MilesAccountId}/redeemVoucher/{VoucherId}")
    public Object redeemVoucher(@PathVariable Long MilesAccountId, @PathVariable Long VoucherId) {
        Map<String, String> ReturnArr = ProjectFunction.initAPIMessage();
        Voucher RedeemingVoucherObj = VoucherRepository.LoadById(VoucherId);
        MilesAccount MilesAccountObj = MilesAccountRepository.loadActiveMilesAccountById(MilesAccountId);
        if (RedeemingVoucherObj != null && MilesAccountObj != null) {
            if (RedeemingVoucherObj.MilesCost > MilesAccountObj.TotalMilesEarned) {
                ProjectFunction.setAPIOutput(ReturnArr, false);
                ProjectFunction.setAPIValue(ReturnArr, "Message", "You do not have enough miles to redeem voucher");
                return ReturnArr;
            }

            MilesSpent SpendingMilesObj = new MilesSpent();
            SpendingMilesObj.MilesAccount = MilesAccountObj;
            SpendingMilesObj.DateAccumulated = new Timestamp(new Date().getTime());
            SpendingMilesObj.Voucher = RedeemingVoucherObj;

            float DiscountedMiles = RedeemingVoucherObj.MilesCost;
            if (RedeemingVoucherObj.DiscountedPercentage > 0) {
                DiscountedMiles -= DiscountedMiles * RedeemingVoucherObj.DiscountedPercentage;
            }
            SpendingMilesObj.MilesSpent = DiscountedMiles;
            RedeemingVoucherObj.Redeemed = true;
            MilesAccountObj.TotalMilesEarned -= DiscountedMiles;
            try {
                MileSpentRepository.save(SpendingMilesObj);
                VoucherRepository.save(RedeemingVoucherObj);
                MilesAccountRepository.save(MilesAccountObj);
            } catch (Exception ExceptionObj) {
                ProjectFunction.setAPIOutput(ReturnArr, false);
                ProjectFunction.setAPIValue(ReturnArr, "Message", ExceptionObj.getMessage());
                return ReturnArr;
            }
        } else {
            ProjectFunction.setAPIOutput(ReturnArr, false);
            ProjectFunction.setAPIValue(ReturnArr, "Message", "Could not process redeeming of voucher.");
            return ReturnArr;
        }
        ProjectFunction.setAPIOutput(ReturnArr, true);
        ProjectFunction.setAPIValue(ReturnArr, "Message", "Voucher ("+RedeemingVoucherObj.VoucherName+") successfully redeemed.");
        return ReturnArr;
    }
}
