import Sidebar from "./sidebar.jsx";
import {Box, Spinner, useColorModeValue, useDisclosure} from "@chakra-ui/react";
import Navbar from "./navbar.jsx";
import {useEffect, useState} from "react";
import {getCustomers} from "../../services/client.jsx";

const Layout = ({children}) => {
    const { isOpen, onOpen, onClose } = useDisclosure()

    const [users, setUsers] = useState([])
    const [loading,setLoading] = useState(false)


    useEffect(() => {
        setLoading(true)
        getCustomers().then(res => {

            setUsers(res.data)
        }).catch(err => {
            console.log(err)
        }).finally(() =>{
            setLoading(false)
        })
    }, []);

    console.log(users)
    console.log(loading)

    return <>

        <Box minH="100vh" bg={useColorModeValue('gray.100', 'gray.900')}>
            <Sidebar onClose={onClose} isOpen={isOpen} onOpen={onOpen} />

            <Navbar onOpen={onOpen}/>

            <Box ml={{ base: 0, md: 60 }} p="4">
                {
                    loading ? <Spinner
                        thickness='4px'
                        speed='0.65s'
                        emptyColor='gray.200'
                        color='blue.500'
                        size='xl'
                    /> : children
                }

            </Box>

        </Box>

    </>
}

export default Layout