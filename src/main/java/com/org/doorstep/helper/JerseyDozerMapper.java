/**
 * 
 */
package com.org.doorstep.helper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hariharank12
 *
 */
@Component
public class JerseyDozerMapper<B, T> {

	@Autowired
	private Mapper mapper;

	public T map(final B source, final Class<T> destinationClass)
			throws MappingException {
		return mapper.map(source, destinationClass);
	}

	public List<T> mapList(final List<B> sourceList,
			final Class<T> destinationType) {

		final List<T> destinationList = new ArrayList<T>();
		for (B b : sourceList) {
			System.out.println("adding sublist");
			destinationList.add(map(b, destinationType));

		}
		return destinationList;
	}
}
