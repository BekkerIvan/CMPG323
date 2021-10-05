
import TopNav from "../components/top-nav";

ReactDOM.render(
    <React.StrictMode>
        <TopNav isLoggedIn={global.isLoggedIn}/>
    </React.StrictMode>,
    document.getElementById('root')
);