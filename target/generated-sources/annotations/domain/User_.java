package domain;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> website;
	public static volatile ListAttribute<User, Role> roles;
	public static volatile SingularAttribute<User, String> biography;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SetAttribute<User, User> followers;
	public static volatile SetAttribute<User, User> following;
	public static volatile ListAttribute<User, UUID> mentionedKweets;
	public static volatile SingularAttribute<User, String> location;
	public static volatile SingularAttribute<User, UUID> id;
	public static volatile ListAttribute<User, UUID> Kweets;
	public static volatile ListAttribute<User, UUID> heartedKweets;
	public static volatile SingularAttribute<User, String> username;

}

