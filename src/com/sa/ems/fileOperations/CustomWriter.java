package com.sa.ems.fileOperations;

import java.io.Serializable;
import java.util.List;

public interface CustomWriter {
	void write (List<Serializable> items, String filename);
}
