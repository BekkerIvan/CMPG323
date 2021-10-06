import {Form, FormControl, Nav, Navbar, NavDropdown, Button } from "react-bootstrap";
import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";


global.isLoggedIn = false;

const TopNav = () => {
    return (
        <Router>
        <>
            <Navbar bg="info" expand="lg">
                <Navbar.Brand href="#">Navbar scroll</Navbar.Brand>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="mr-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link as={Link} to={"/App"}>Home</Nav.Link>
                        <Nav.Link href="#action2">Link</Nav.Link>
                        <NavDropdown title="Link" id="navbarScrollingDropdown">
                            <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action4">Another action</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action5">Something else here</NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link href="#" disabled>
                            Link
                        </Nav.Link>
                    </Nav>
                    <div style={{display: global.isLoggedIn ? "none" : "initial"}}>
                        <Form className="d-flex">
                            <FormControl
                                id="Username"
                                type="search"
                                placeholder="Username"
                                className="mr-2"
                                aria-label="Username"
                            />
                            <FormControl
                                id="Password"
                                type="password"
                                placeholder="Password"
                                className="mr-2"
                                aria-label="Password"
                            />
                            <Button className="btn btn-secondary">Login</Button>
                        </Form>
                    </div>
                </Navbar.Collapse>
            </Navbar>
        </>
        <Switch>
            <Route path="/App">
                <App />
            </Route>
            <Route path="/">
                <Home/>
            </Route>
        </Switch>
        </Router>
    )
}

function App() {
    return <div className="container">
    </div>
}
function Home() {
    return <h2>Home</h2>
}

export default TopNav;
