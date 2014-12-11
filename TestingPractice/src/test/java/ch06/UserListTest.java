package test.java.ch06;

import static org.mockito.Mockito.*;
import static org.fest.assertions.api.Assertions.*;

import main.java.ch05.subscribers.User;
import main.java.ch06.UserList;

import org.junit.Test;

public class UserListTest {

	User user1 = mock(User.class);
	User user2 = mock(User.class);
	UserList userList = new UserList();

	@Test
	public void canAddUser() {
		userList.add(user1);
	}

	@Test
	public void addedUserAppearsInGet() {
		userList.add(user1);
		assertThat(userList.getUsers()).isNotNull().contains(user1)
				.doesNotContain(user2);
		
		userList.add(user2);
		assertThat(userList.getUsers()).isNotNull().contains(user1, user2);
	}

	@Test
	public void getUserBeforeAddingShouldNotBeEmpty() {
		assertThat(userList).isNotNull();
	}
	
	@Test
	public void shouldOnlyHaveOneUserIfOnlyOneAdded() {
		userList.add(user2);
		assertThat(1).isEqualTo(userList.getUsers().size());
	}
	
	@Test
	public void canNotAddSameUserTwice() {
		userList.add(user2);
		userList.add(user2);
		assertThat(userList.getUsers()).containsOnly(user2);
		assertThat(userList.getUsers().size()).isEqualTo(1);
	}
	
	@Test
	public void canAddMoreThanOneUser() {
		userList.add(user1);
		userList.add(user2);
		
		
		assertThat(userList.getUsers()).hasSize(2);
		assertThat(userList.getUsers()).contains(user1, user2);
	}
}
