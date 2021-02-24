
package cadastrofornecedores;

import java.util.ArrayList;

/**
 *
 * @author Ana Paula
 */
public class Fornecedores {
    private String Nome;
    private String Cargo;
    private String Empresa;
    private String TipoDeEmpresa;
    private String Telefone;
    private String Email;
    private String Assunto;

    ArrayList<Fornecedores> ListaFornecedores;

    public Fornecedores() {
        ListaFornecedores = new ArrayList();
    }

    public Fornecedores(String Nome, String Cargo, String Empresa, String TipoDeEmpresa, String Telefone, String Email, String Assunto) {

        this.Nome = Nome;
        this.Cargo = Cargo;
        this.Empresa = Empresa;
        this.TipoDeEmpresa = TipoDeEmpresa;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Assunto = Assunto;

        ListaFornecedores = new ArrayList();
    }

    Fornecedores(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getTipoDeEmpresa() {
        return TipoDeEmpresa;
    }

    public void setTipoDeEmpresa(String TipoDeEmpresa) {
        this.TipoDeEmpresa = TipoDeEmpresa;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String Assunto) {
        this.Assunto = Assunto;
    }

    public ArrayList<Fornecedores> getListaFornecedores() {
        return ListaFornecedores;
    }

    public void setListFornecedores(ArrayList<Fornecedores> ListaFornecedores) {
        this.ListaFornecedores = ListaFornecedores;
    }

    public void addFornecedor(Fornecedores X) {
        ListaFornecedores.add(X);
    }
    
    
}
