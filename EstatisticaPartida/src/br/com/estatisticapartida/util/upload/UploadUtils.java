package br.com.estatisticapartida.util.upload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

public class UploadUtils {
	public static String gravarTxt(FileUploadEvent fileUploadEvent) {
		UploadedFile uploadedFile = fileUploadEvent.getFile();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Path folder = Paths.get(facesContext.getExternalContext().getRealPath("/"));
		Path file = null;
		try (InputStream input = uploadedFile.getInputstream()) {
			file = Files.createTempFile(folder, "LogPartida", ".txt");
			Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			facesContext.addMessage(null, new FacesMessage("Erro", "Ao importar arquivo TXT"));
		}
		return file.toString();
	}

}
