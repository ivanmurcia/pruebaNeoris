package com.pruebaneoris.microservicios.app.prueba.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="cuentas")
public class Cuenta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Long idCuenta;
	
	@NotEmpty
	@Column(name = "numero_cuenta")
	private String numeroCuenta;
	
	@NotEmpty
	@Column(name = "tipo_Cuenta")
	private String tipoCuenta;
	
	@NotNull
	@Column(name = "saldo_inicial")
	private BigDecimal saldoInicial;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@ManyToOne
    private Cliente cliente;
    
	/*
	 * Getter and Setter
	 */
    public Long getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", numeroCuenta=" + numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", saldoInicial="
				+ saldoInicial + ", estado=" + estado + ", cliente=" + cliente + "]";
	}
			
}
