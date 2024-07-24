package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.AddressRequestDto;
import com.workintech.ecommerce_backend.entity.Address;
import com.workintech.ecommerce_backend.entity.User;
import com.workintech.ecommerce_backend.mapper.AddressMapper;
import com.workintech.ecommerce_backend.repository.AddressRepository;
import com.workintech.ecommerce_backend.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements  AddressService{

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        /*
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            return address.get();
        }
        */
        return addressRepository.findById(id).orElseThrow(null) ;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }


    @Override
    public Address delete(Long id) {
        Address address = findById(id);
        addressRepository.delete(address);
        return address;
    }

    @Transactional
    @Override
    public Address addAddress(AddressRequestDto addressRequestDto, String user_mail) {
        Optional<User> user = userRepository.findByEmail(user_mail);
        if (user.isPresent()) {
            Address address = AddressMapper.addressRequestDtoToAddress(addressRequestDto);

            address.addUser(user.get());
         // user.get().addAddress(address);
         //   userRepository.save(user.get());
            return save(address);
        }
        throw new RuntimeException("User not found");
    }
}
