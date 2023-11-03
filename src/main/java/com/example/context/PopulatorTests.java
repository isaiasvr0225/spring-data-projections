package com.example.context;

import com.example.persistence.entity.Address;
import com.example.persistence.entity.Employee;
import com.example.persistence.repository.AddressRepository;
import com.example.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PopulatorTests implements InitializingBean {

	private AddressRepository addressRepository;
	private EmployeeRepository employeeRepository;

	public PopulatorTests(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
		super();
		this.addressRepository = addressRepository;
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info(" === Vamos a popular la base de datos");
		populate();
		log.info("=== Fin");
	}

	public void populate() {

		for (int i = 1; i <= 10; i++) {
			Address addressSaved = this.addressRepository.save(getRandomAddress(i));
			Employee tempEmployee = getRandomPerson(i);
			tempEmployee.setAddressId(addressSaved.getId());
			this.employeeRepository.save(tempEmployee);
		}

	}

	private Address getRandomAddress(int i) {

		Address address = new Address();
		address.setCity("City " + i);
		address.setCountry("Country " + i);
		address.setPostalCode(i);
		address.setState("State " + i);
		address.setStreet("Street " + i);
		return address;
	}

	private Employee getRandomPerson(int i) {
		Employee p = new Employee();
		p.setName("Pepito " + i);
		p.setEmail("pepito" + i + "@gmail.com");
		p.setPhoneNumber("45785125" + i);
		return p;
	}

}
