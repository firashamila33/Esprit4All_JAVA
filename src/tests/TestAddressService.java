/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import services.AddressService;
import models.Address;

/**
 *
 * @author kadhem
 */
public class TestAddressService {

    public static void testAdd() {
        AddressService addressService = new AddressService();

        addressService.add(new Address("Tunis", "REpublique", "21", "en face de monoprix"));
    }

    public static void testUpdate() {
        AddressService addressService = new AddressService();
        Address a = new Address("Ben arous", "Jassmin", "21", "en face de monoprix");
        addressService.add(a);
        a.setHomeNumber("45");
        addressService.update(a);
    }

    public static void testDelete() {
        AddressService addressService = new AddressService();
        Address a = new Address("SHould never see it", "Jassmin", "21", "en face de monoprix");
        addressService.add(a);
        addressService.delete(a.getId());

    }

    public static void testGetAll() {
        AddressService addressService = new AddressService();
        for (Address a : addressService.getAll()) {
            System.out.println("Addresse " + a);
        }

    }

    public static void main(String[] args) {

        TestAddressService.testAdd();
        TestAddressService.testUpdate();
        TestAddressService.testDelete();
        TestAddressService.testGetAll();
        System.out.println("Helllo");

    }
}
