import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {ChakraProvider, createStandaloneToast} from "@chakra-ui/react";

const {ToastContainer} = createStandaloneToast()

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <ChakraProvider>
            <ToastContainer/>
            <App/>
        </ChakraProvider>

    </React.StrictMode>,
)
