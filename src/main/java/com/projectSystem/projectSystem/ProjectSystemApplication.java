package com.projectSystem.projectSystem;

import com.projectSystem.projectSystem.model.PermissionEntity;
import com.projectSystem.projectSystem.model.RoleEntity;
import com.projectSystem.projectSystem.model.RoleEnum;
import com.projectSystem.projectSystem.model.UserEntity;
import com.projectSystem.projectSystem.repository.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ProjectSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSystemApplication.class, args);
	}


	@Bean
	CommandLineRunner init(UserEntityRepository userEntityRepository){
		return args->{
			/*Creo los permisos*/

			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			/*Creo los roles*/

			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission))
					.build();

			/*CREATE USERS*/

			UserEntity userEsteban = UserEntity.builder()
					.name("esteban")
					.email("juanes@gmail.com")
					.password("$2a$10$SF4XUCMWBG53RZ..HjyuRus8gkqWO36bk71n2wThEluHeb8BkyVJ.")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userDavid = UserEntity.builder()
					.name("david")
					.email("david@gmail.com")
					.password("$2a$10$SF4XUCMWBG53RZ..HjyuRus8gkqWO36bk71n2wThEluHeb8BkyVJ.")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			userEntityRepository.saveAll(List.of(userEsteban,userDavid));

		};

	}
}
