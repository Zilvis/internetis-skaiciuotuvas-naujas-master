package com.mokslai.internetisskaiciuotuvas.Service;

import com.mokslai.internetisskaiciuotuvas.model.SkaiciusZenklas;
import java.util.List;

public interface SkaiciaiService {

    void insert (SkaiciusZenklas skaicius);

    SkaiciusZenklas getById(int id);

    List<SkaiciusZenklas> getAll();

    void update(SkaiciusZenklas skaicius);

    void delete(int id);
}
