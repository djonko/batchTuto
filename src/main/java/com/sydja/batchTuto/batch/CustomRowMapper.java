package com.sydja.batchTuto.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sydja.batchTuto.model.Message;



public class CustomRowMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message=new Message();
		message.setId(rs.getInt("id"));
		message.setStatut(rs.getString("statut"));
		message.setContent(rs.getString("content"));
		message.setEmail(rs.getString("email"));
		return message;
	}



}
