

const authentication = () => {

    const authenticateUser = () => {
        let password = document.getElementById("Password").value;
        let username = document.getElementById("Username").value;
        fetch('http://127.0.0.1:8080/login?username='+username+'&password='+password, {
            method: "GET"
         })
        .then(response => response.json())
        .then(response => {
            console.log(response);
            if (response) {
                global.isLoggedIn = true;
            }
        })
        .catch(err => {
            console.log(err);
        });
    }

    return (
        <>
            <input type={"text"} className="form-control mr-2" id={"Username"} placeholder="Username"/>
            <input type={"password"} className="form-control mr-2" id={"Password"} placeholder="Password"/>
            <button className="btn btn-primary" onClick={authenticateUser}>Login</button>
        </>
    )
}

export default authentication;