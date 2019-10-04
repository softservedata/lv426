package com.softserve.edu.rest.tools;

import java.util.List;

public abstract class AExternalReader {

	public final int PATH_PREFIX = 6;
    public final String PATH_SEPARATOR = "/";
    //
    //public static Logger log = LogManager.GetCurrentClassLogger(); // for NLog

    public String name;
    public String path;

    protected AExternalReader(String name)
    {
        this.name = name;
		this.path = this.getClass().getResource(PATH_SEPARATOR + name).getPath(); //.substring(1);
    }

    protected AExternalReader(String name, String path)
    {
        this.name = name;
        this.path = path;
    }

    // getters
    
    public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public List<List<String>> getAllCells()
    {
        return getAllCells(path);
    }

    public abstract List<List<String>> getAllCells(String path);
}
