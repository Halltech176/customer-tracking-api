'use client'

import {
    Heading, Avatar, Box, Image, Flex, Text, Stack, Button, useColorModeValue,
} from '@chakra-ui/react'

const CardItem = ({customer}) => {
    const userGender = customer.gender === 'MALE' ? "men" : "women";
    return (

        <Box
            maxW={'270px'}
            w={'full'}
            bg={useColorModeValue('white', 'gray.800')}
            boxShadow={'2xl'}
            rounded={'md'}
            overflow={'hidden'}>
            <Image
                h={'120px'}
                w={'full'}
                src={'https://images.unsplash.com/photo-1612865547334-09cb8cb455da?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80'}
                objectFit="cover"
                alt="#"
            />
            <Flex justify={'center'} mt={-12}>
                <Avatar
                    size={'xl'}
                    src={`https://randomuser.me/api/portraits/${userGender}/${customer?.age}.jpg`}
                    css={{
                        border: '2px solid white',
                    }}
                />
            </Flex>

            <Box p={6}>
                <Stack spacing={0} align={'center'} mb={5}>
                    <Heading fontSize={'2xl'} fontWeight={500} fontFamily={'body'}>
                        {customer?.name}
                    </Heading>
                    <Text color={'gray.500'}>{customer?.email}</Text>
                    <Text color={'gray.500'}>Frontend Developer</Text>
                </Stack>

                <Stack direction={'row'} justify={'center'} spacing={6}>
                    <Stack spacing={0} align={'center'}>
                        <Text fontWeight={600}>{customer?.age}</Text>
                        <Text fontSize={'sm'} color={'gray.500'}>
                            Age
                        </Text>
                    </Stack>
                    <Stack spacing={0} align={'center'}>
                        <Text fontWeight={600}>{customer?.gender}</Text>
                        <Text fontSize={'sm'} color={'gray.500'}>
                            Gender
                        </Text>
                    </Stack>
                </Stack>

                <Button
                    w={'full'}
                    mt={8}
                    bg={useColorModeValue('#151f21', 'gray.900')}
                    color={'white'}
                    rounded={'md'}
                    _hover={{
                        transform: 'translateY(-2px)', boxShadow: 'lg',
                    }}>
                    Follow
                </Button>
            </Box>
        </Box>

    )
}

export default CardItem