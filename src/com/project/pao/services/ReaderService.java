package com.project.pao.services;

import com.project.pao.csvIO.ReaderInput;
import com.project.pao.csvIO.ReaderOutput;
import com.project.pao.entities.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderService {

    public static ReaderService service;

    private ReaderService() {}

    public static ReaderService getService() {
        if (service == null)
            service = new ReaderService();
        return service;
    }

    public List<Reader> getReaders() {

        List<Reader> readers = new ArrayList<Reader>();

        ReaderInput readerInput = ReaderInput.getInput();

        readers = readerInput.input(readers);

        return readers;
    }

    public void setReaders(List<Reader> readers) {

        ReaderOutput readerOutput = ReaderOutput.getOutput();

        for (Reader reader : readers) {
            readerOutput.outputReader(reader);
        }

    }
}
