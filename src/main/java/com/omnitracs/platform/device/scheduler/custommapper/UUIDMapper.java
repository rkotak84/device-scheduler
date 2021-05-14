package com.omnitracs.platform.device.scheduler.custommapper;

import java.io.IOException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.omnitracs.platform.device.utils.CommonUtils;

public class UUIDMapper extends StdDeserializer<UUID> {

	public UUIDMapper(Class<?> vc) {
		super(vc);
	}

	public UUIDMapper() {
		this(null);
	}

	private static final long serialVersionUID = -8038322420403294333L;

	@Override
	public UUID deserialize(JsonParser value, DeserializationContext ctxt) throws IOException {
		return CommonUtils.transformToUUID(value.getText());
	}
}
