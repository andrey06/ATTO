package com.aestheticintegration.atto.dataobject;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class HelpObject {
	List<Object> item;
}
