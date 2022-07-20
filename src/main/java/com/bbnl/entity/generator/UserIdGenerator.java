package com.bbnl.entity.generator;

import java.io.Serializable;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "usr";
		Connection connection = session.connection();
		try {
			Statement statement=connection.createStatement();

			ResultSet rs=statement.executeQuery("select max(user_id) as Id from users");

			if(rs.next()) {
				if(rs.getString(1) == null) {
					String generatedId = prefix + "1000";
					return generatedId;						
				}
				else {
					String userstr = rs.getString(1).substring(3);
					int usrint = Integer.parseInt(userstr)+1;
					String generatedId = prefix + Integer.toString(usrint);
					return generatedId;
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}