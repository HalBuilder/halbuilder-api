package com.theoryinpractise.halbuilder.api;

import java.io.Reader;

public interface RepresentationReader {
    ReadableRepresentation read(Reader source);
}
