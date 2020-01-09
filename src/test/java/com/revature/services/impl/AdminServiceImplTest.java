package com.revature.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Admin;
import com.revature.repositories.AdminRepository;

@RunWith(SpringRunner.class)
public class AdminServiceImplTest {
	
	@InjectMocks
	private AdminServiceImpl asi;
	
	@Mock
	private AdminRepository ar;
	
	@Test
	public void testGettingAdmins() {
		
		List<Admin> admins = new ArrayList<>();
		admins.add(new Admin());
		admins.add(new Admin());
		when(ar.findAll()).thenReturn(admins);
		
		assertEquals(asi.getAdmins().size(), 2);

	}
	
	@Test
	public void testGettingAdminById() {
		
		Admin expected = new Admin(1, "username");
		when(ar.getOne(1)).thenReturn(expected);
		Admin actual = asi.getAdminById(1);
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testCreatingAdmin() {
		
		Admin expected = new Admin(1, "username");
		when(ar.save(expected)).thenReturn(expected);
		Admin actual = asi.createAdmin(expected);
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testUpdatingAdmin() {
		
		Admin expected = new Admin(1, "username");
		when(ar.save(expected)).thenReturn(expected);
		Admin actual = asi.updateAdmin(expected);
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testDeletingAdmin() {
		
		String expected = "Admin with id: 1 was deleted.";
		when(ar.existsById(1)).thenReturn(true);
		String actual = asi.deleteAdminById(1);
		
		assertEquals(actual, expected);
	}
	
}
