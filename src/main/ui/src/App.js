import logo from './logo.svg';
import './App.css';

function App() {
    const name = "Ivan";

  return (
    <div className="container" style={{height:"1500px"}}>
        <div className="row text-center">
            <div className="col-6">asd</div>
            <div className="col-6">{name}</div>
        </div>
    </div>
  );
}

export default App;
