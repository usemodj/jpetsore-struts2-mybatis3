package com.usemodj.jpetstore.mappers;

import com.usemodj.jpetstore.domain.Sequence;

public interface SequenceMapper {

	Integer selectNextId(String ord);

	void insertSequence(Sequence sequence);

	void updateSequence(Sequence sequence);

}
