import './App.css'
import Userprofile from "./pages/userprofile.jsx";
import Routes from "./routes/index.jsx";
import CustomerProvider from "./context/customers.jsx";


const names = [{
  name : "Olajide",
  age : 30,
  gender : "men"
}]



function App() {


  return (
    <>
      <CustomerProvider>
        <Routes/>
      </CustomerProvider>


    </>
  )
}

export default App
