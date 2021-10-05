import Auth from "./authentication"
global.isLoggedIn = false;
const TopNav = (props) => {
    return (
        <nav className="navbar sticky-top navbar-expand-lg navbar-light bg-secondary">
            <a className="navbar-brand" href="#">Account System</a>
            <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav mr-auto" style={{display: global.isLoggedIn ? "initial" : "none"}}>
                    <li className="nav-item active">
                        <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
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
                <div className="ml-auto d-flex">
                    <Auth/>
                </div>
            </div>
        </nav>
    )
}
export default TopNav;
