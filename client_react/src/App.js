import './App.css';
import {useEffect, useState} from "react";
import Axios from "axios";


function App() {

  const [routeDuJour, setRouteDuJour] = useState(false);

    useEffect(() => {
        getRouteJour();
    }, []);

  function getRouteJour(){
    Axios.get("http://172.20.45.21:8080/serviceREST-0.0.1-SNAPSHOT/routeDuJour").then((response) => {
          setRouteDuJour(response)
    });
  }

  return (
    <div className="App">
      <h1>Voici les routes pour la journee</h1>
      <p>{routeDuJour}</p>
    </div>
  );
}

export default App;
