package com.project.gama.command;

import java.util.List;

public interface GamaCommand {

	public <T> T doExecute();
}
