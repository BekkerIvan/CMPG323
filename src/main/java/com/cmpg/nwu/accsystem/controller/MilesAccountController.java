package com.cmpg.nwu.accsystem.controller;
import com.cmpg.nwu.accsystem.orm.entity.EarnedMiles;
import com.cmpg.nwu.accsystem.orm.entity.MilesAccount;
import com.cmpg.nwu.accsystem.orm.repo.EarnedMilesRepository;
import com.cmpg.nwu.accsystem.orm.repo.MilesAccountRepository;
import com.cmpg.nwu.accsystem.project_functions.ProjectFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
public class MilesAccountController {
    @Autowired
    private MilesAccountRepository MilesAccountRepository;
    @Autowired
    private EarnedMilesRepository EarnedMilesRepository;

    @GetMapping("/{MilesAccountId}/receiveMiles/{MilesAmountFlt}")
    public Object accumulateMiles(@PathVariable Integer MilesAccountId, @PathVariable int MilesAmountFlt) {
        MilesAccount EnquiredMilesAccountObj = MilesAccountRepository.loadActiveMilesAccountById(MilesAccountId);
        Map<String, String> ReturnArr = ProjectFunction.initAPIMessage();
        if (EnquiredMilesAccountObj == null) {
            ProjectFunction.setAPIOutput(ReturnArr, false);
            ProjectFunction.setAPIValue(ReturnArr, "Message",  "Failed to update MilesAccount: "+MilesAccountId);
        } else {
            EnquiredMilesAccountObj.TotalMilesEarned += MilesAmountFlt;
            EarnedMiles NewEarnedMiles = new EarnedMiles();
            NewEarnedMiles.MilesAccount = EnquiredMilesAccountObj;
            NewEarnedMiles.DateEarned = new Timestamp(new Date().getTime());
            try {
                MilesAccountRepository.save(EnquiredMilesAccountObj);
                EarnedMilesRepository.save(NewEarnedMiles);
                ProjectFunction.setAPIOutput(ReturnArr, true);
                ProjectFunction.setAPIValue(ReturnArr, "Message", "total miles so far = " + EnquiredMilesAccountObj.TotalMilesEarned);

            } catch (Exception ExceptionObj) {
                ProjectFunction.setAPIOutput(ReturnArr, false);
                ProjectFunction.setAPIValue(ReturnArr, "Message", ExceptionObj.getMessage());
            }
        }
        return ReturnArr;
    }

    @GetMapping("/{MilesAccountId}/viewMiles")
    public Object viewMiles(@PathVariable Integer MilesAccountId) {
        MilesAccount EnquiredMilesAccountObj = MilesAccountRepository.loadActiveMilesAccountById(MilesAccountId);
        Map<String, String> ReturnArr = ProjectFunction.initAPIMessage();
        if (EnquiredMilesAccountObj == null) {
            ProjectFunction.setAPIOutput(ReturnArr, false);
            ProjectFunction.setAPIValue(ReturnArr, "Message",  "Failed to get MilesAccount: "+MilesAccountId);
            return ReturnArr;
        }
        ProjectFunction.setAPIOutput(ReturnArr, true);
        ProjectFunction.setAPIValue(ReturnArr, "Message", "Current Miles = " + EnquiredMilesAccountObj.TotalMilesEarned);
        ProjectFunction.setAPIValue(ReturnArr, "Miles", String.valueOf(EnquiredMilesAccountObj.TotalMilesEarned));
        return ReturnArr;
    }
}
