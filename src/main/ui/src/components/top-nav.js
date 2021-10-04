import {useEffect} from "react";

const TopNav = () => {
    const onclick = async () => {

    }
    useEffect( () => {
           const test = fetch('http://192.168.88.57:8080/hello', {method: "GET"});
        }
    );

    return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-secondary">
            <a className="navbar-brand" href="#">Navbar</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"/>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav">
                    <li className="nav-item active">
                        <a className="nav-link" href="#" onClick={onclick}>Home <span className="sr-only">(current)</span></a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">Features</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">Pricing</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link disabled" href="#" tabIndex="-1" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
            </div>
        </nav>
    )
}
export default TopNav;
