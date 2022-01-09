package com.mpinfo.servicosprof.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.mpinfo.servicosprof.domain.PagamentoComPix;

@Service
public class PixService {
 
	public void preencherPagamentoComPix(PagamentoComPix pagto, Date instanteDoChamado) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoChamado);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		pagto.setDataVencimento(cal.getTime());
	}
}
