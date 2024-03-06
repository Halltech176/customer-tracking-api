import {createContext, useContext, useEffect, useState} from "react";
import {useDisclosure} from "@chakra-ui/react";
import {getCustomers} from "../services/client.jsx";


const initialState = {
    customers : [],
    loading: false
}
const CustomerContext = createContext(initialState)

const CustomerProvider = ({children}) => {

    const [customers, setCustomers] = useState([])
    const [loading,setLoading] = useState(false)

    useEffect(() => {
        setLoading(true)
        getCustomers().then(res => {

            setCustomers(res.data)
        }).catch(err => {
            console.log(err)
        }).finally(() =>{
            setLoading(false)
        })
    }, []);

    const value = {customers, loading}
    return <CustomerContext.Provider value={value}>
        {children}
    </CustomerContext.Provider>
}

export const useCustomers = () => {
    return useContext(CustomerContext)
}

export  default  CustomerProvider