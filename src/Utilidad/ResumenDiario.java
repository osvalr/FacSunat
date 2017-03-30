
package Utilidad;
import AccessoDato.EEmpresa;
import AccessoDato.EResumenDiario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.AllowanceChargeType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.AttachmentType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PartyLegalEntityType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PaymentType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.SignatureType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.SupplierPartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxCategoryType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxSchemeType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxSubtotalType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxTotalType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.AmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.PaidAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.TaxAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonExtensionComponents2.ExtensionContentType;
import oasisNamesSpecificationUblSchemaXsdCommonExtensionComponents2.UBLExtensionsType;
import org.apache.xmlbeans.XmlCursor;
import org.w3c.dom.Node;
import sunat.Envio;
import sunatNamesSpecificationUblPeruSchemaXsdSummaryDocuments1.SummaryDocumentsDocument;
import sunatNamesSpecificationUblPeruSchemaXsdSummaryDocuments1.SummaryDocumentsType;
import sunatNamesSpecificationUblPeruSchemaXsdSunatAggregateComponents1.AdditionalInformationType;
import sunatNamesSpecificationUblPeruSchemaXsdSunatAggregateComponents1.SummaryDocumentsLineType;
import unUneceUncefactCodelistSpecification542172001.CurrencyCodeContentType;


public class ResumenDiario {
    
    private SummaryDocumentsDocument _sumary;
    SummaryDocumentsType _sd;
    String rutaXml="";
    String rutazip="";
    File fa =null;
    File fa2=null;
    ExtensionContentType _nodoFirma;
    private Envio _envioSunat;
    private String strUsuario;
    private String strClave;
    private boolean _estado;
    public String errReferenceID= "";
    public String errResponseCode= "";
    public String errDescription="";
    private EEmpresa _eempresa;
    private List<EResumenDiario> _lsresumen;
    ExtensionContentType _extensiontype;
    AdditionalInformationType _addtypeinfo;
    InputStream inputxml;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Formato _fmd;
    public ResumenDiario(EEmpresa x_empresa,List<EResumenDiario> x_resument)
    {
        _fmd = new Formato();
        _eempresa=x_empresa;
        _lsresumen=x_resument;
    }
    private void addUBLExtensions()
    {
        try
        {
            UBLExtensionsType _ubltype= _sd.addNewUBLExtensions();//--------------------------Tag principales
             _nodoFirma =_ubltype.addNewUBLExtension().addNewExtensionContent();//----------Tag para firma digital
            // _ubltype.addNewUBLExtension().addNewExtensionContent(); //---------------------Tag para Additionalinformation             
        }
        catch(Exception e)
        {System.out.println("Creacion Tag principales UBLExtensions :"+e.getMessage());}
    }

    private void addSignature()
    {
        try
        {
            SignatureType _sigtype=_sd.addNewSignature();
             _sigtype.addNewID().setStringValue("IDSignKG");
             PartyType _party=_sigtype.addNewSignatoryParty();
             _party.addNewPartyIdentification().addNewID().setStringValue(getEempresa().getEmp_cruc());
             _party.addNewPartyName().addNewName().setStringValue(getEempresa().getEmp_cnombre());             
             AttachmentType _atttype=_sigtype.addNewDigitalSignatureAttachment();
             _atttype.addNewExternalReference().addNewURI().setStringValue("#signatureKG"); 
        }catch(Exception e)
        {System.out.println("Creacion Tag Signature :"+e.getMessage());}
    }
    private void addAccountingSuplierParty()//---------------------------------------------------------------------------Datos del emisor
    {
        try
        {
            SupplierPartyType _addacountingsupplierparty= _sd.addNewAccountingSupplierParty();
             _addacountingsupplierparty.addNewCustomerAssignedAccountID().setStringValue(getEempresa().getEmp_cruc());
             _addacountingsupplierparty.addNewAdditionalAccountID().setStringValue("6");//registro unico de contribuyente             
             PartyType _party=_addacountingsupplierparty.addNewParty();
             PartyLegalEntityType _partylegalentity=_party.addNewPartyLegalEntity();
             _partylegalentity.addNewRegistrationName().setStringValue(getEempresa().getEmp_cnombre());
             for (int i=0;i<_lsresumen.size();i++)
             {
                 SummaryDocumentsLineType _nuevosumary=_sd.addNewSummaryDocumentsLine();

                 _nuevosumary.addNewLineID().setStringValue(""+(i+1));
                 String _strcodigo=_lsresumen.get(i).getTipodocumento();
                 _nuevosumary.addNewDocumentTypeCode().setStringValue(_strcodigo);
                 _nuevosumary.addNewDocumentSerialID().setStringValue(_lsresumen.get(i).getNum_serie());
                 _nuevosumary.addNewStartDocumentNumberID().setStringValue(""+_lsresumen.get(i).getIni_rango());
                 _nuevosumary.addNewEndDocumentNumberID().setStringValue(""+(_lsresumen.get(i).getFin_rango()));
                 AmountType _totalamounttype=_nuevosumary.addNewTotalAmount();
                 _totalamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _totalamounttype.setStringValue(""+_lsresumen.get(i).getImptotal());
                 
                 PaymentType palment=_nuevosumary.addNewBillingPayment();
                 //operacion gravada
                 PaidAmountType _paiamounttype= palment.addNewPaidAmount();
                 palment.addNewInstructionID().setStringValue("01");
                 _paiamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _paiamounttype.setStringValue(""+_lsresumen.get(i).getVtagravada());
                 //exogenadas
                 palment=_nuevosumary.addNewBillingPayment();
                 _paiamounttype= palment.addNewPaidAmount();
                 palment.addNewInstructionID().setStringValue("02");
                 _paiamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _paiamounttype.setStringValue("0.00");
                 //inafecta
                 palment=_nuevosumary.addNewBillingPayment();
                 _paiamounttype= palment.addNewPaidAmount();
                 palment.addNewInstructionID().setStringValue("03");
                 _paiamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _paiamounttype.setStringValue("0.00");
                 
                 AllowanceChargeType _allowchange=_nuevosumary.addNewAllowanceCharge();
                 _allowchange.addNewChargeIndicator().setStringValue("false");
                 AmountType _amounttype2=_allowchange.addNewAmount();
                 _amounttype2.setCurrencyID(CurrencyCodeContentType.PEN);
                 _amounttype2.setStringValue("0.00");
                 //ISC
                 TaxTotalType _taxtype=_nuevosumary.addNewTaxTotal();
                 TaxAmountType _amounttype=_taxtype.addNewTaxAmount();
                 _amounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _amounttype.setStringValue("0.00");
                 TaxSubtotalType taxsubtoal=_taxtype.addNewTaxSubtotal();
                 _amounttype= taxsubtoal.addNewTaxAmount();
                 _amounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _amounttype.setStringValue("0.0");
                 TaxCategoryType _taxcategoria= taxsubtoal.addNewTaxCategory();
                 TaxSchemeType _schemaType=_taxcategoria.addNewTaxScheme();
                 _schemaType.addNewID().setStringValue("2000");
                 _schemaType.addNewName().setStringValue("ISC");
                 _schemaType.addNewTaxTypeCode().setStringValue("EXC");
                 //IGV
                 
                 TaxTotalType _taxtype2=_nuevosumary.addNewTaxTotal();
                 _amounttype=_taxtype2.addNewTaxAmount();
                 _amounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _amounttype.setStringValue(""+_lsresumen.get(i).getIgvt());
                 taxsubtoal=_taxtype2.addNewTaxSubtotal();
                 _amounttype= taxsubtoal.addNewTaxAmount();
                 _amounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _amounttype.setStringValue(""+_lsresumen.get(i).getIgvt());
                 _taxcategoria= taxsubtoal.addNewTaxCategory();
                 _schemaType=_taxcategoria.addNewTaxScheme();
                 _schemaType.addNewID().setStringValue("1000");
                 _schemaType.addNewName().setStringValue("IGV");
                 _schemaType.addNewTaxTypeCode().setStringValue("VAT");
//                 //OTROS TRIBUTOS
                 TaxTotalType _taxtype3=_nuevosumary.addNewTaxTotal();
                 _amounttype=_taxtype3.addNewTaxAmount();
                 _amounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _amounttype.setStringValue("0.00");
                 taxsubtoal=_taxtype3.addNewTaxSubtotal();
                 _amounttype=taxsubtoal.addNewTaxAmount();
                 _amounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                 _amounttype.setStringValue("0.0");
                 _taxcategoria= taxsubtoal.addNewTaxCategory();
                 _schemaType=_taxcategoria.addNewTaxScheme();
                 _schemaType.addNewID().setStringValue("9999");
                 _schemaType.addNewName().setStringValue("OTROS");
                 _schemaType.addNewTaxTypeCode().setStringValue("OTH");
             
             }
             
        }
        catch(Exception e)
        {System.out.println("Creacion Tag AddAccountingSiplierParty :"+e.getMessage());}
    }

    private void addTagHeader()
    {
        try
        {
            XmlCursor _cursor=   _sd.newCursor();
            _cursor.toNextToken();  
            _cursor.insertNamespace(null,"urn:sunat:names:specification:ubl:peru:schema:xsd:SummaryDocuments-1");
            _cursor.insertNamespace("cac", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
            _cursor.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
            _cursor.insertNamespace("ext","urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
            _cursor.insertNamespace("ds","http://www.w3.org/2000/09/xmldsig#");
            _cursor.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
            _cursor.insertNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance");
           
        }     
        catch(Exception e)
        {}
    }
    private void addNamesFile()
    {
        try
        {
            Date date = new Date();
//            String _formatofecha=dateFormat.format(date).toString();
//            _formatofecha=_formatofecha.replace("-", "");
            rutaXml= Ruta.rutaResumenDiario +_eempresa.getEmp_cruc()+"-RC-"+dateFormat.format(new Date()).replace("-", "")+"-001.xml";
            rutazip=Ruta.rutaResumenDiario +_eempresa.getEmp_cruc()+"-RC-"+dateFormat.format(new Date()).replace("-", "")+"-001.zip";
            fa= new File(rutaXml);
            
        }
        catch(Exception e)
        {System.out.println("Error al definir files:"+e.getMessage());}
    }
       
    private void ZipFile()
    {
        try
        {
            fa2= new File(rutazip);//-------------------------------------------------------ZIP
             if(fa2.isFile())
                 fa2.delete();
             byte[] buffer =new byte[(int)fa.length()];
             FileOutputStream fos= new FileOutputStream(rutazip);
             ZipOutputStream _mizip = new ZipOutputStream(fos);
             ZipEntry ze= new ZipEntry(fa.getName());
             _mizip.putNextEntry(ze);
             FileInputStream in = new FileInputStream(rutaXml);
             int _tamanio;
             while((_tamanio=in.read(buffer))>0)
                 _mizip.write(buffer, 0, _tamanio);                
             _mizip.closeEntry();
             _mizip.close();
             fos.close();
        }catch(Exception e)
        {System.out.println("Problemas al generar zip :"+e.getMessage());}
    }
    public boolean  FillXml()
    {
        _estado=true;
        try
        {
            addNamesFile();
            _sumary= SummaryDocumentsDocument.Factory.newInstance();
            _sd = _sumary.addNewSummaryDocuments();
            addTagHeader();
            _sumary.documentProperties().setEncoding("ISO-8859-1");
            _sumary.documentProperties().setStandalone(false);
            addUBLExtensions();
            _sd.addNewUBLVersionID().setStringValue("2.0");
            _sd.addNewCustomizationID().setStringValue("1.1");//-
            _sd.addNewID().setStringValue("RC-"+dateFormat.format(new Date()).replace("-", "")+"-001");
            _sd.addNewReferenceDate().setStringValue(""+dateFormat.format(new Date()));
            _sd.addNewIssueDate().setStringValue(""+dateFormat.format(new Date()));
            addSignature();
            addAccountingSuplierParty();
           inputxml=_sumary.newInputStream();
            GenerarFirma();
            ZipFile();
            _estado=true;            
        }
        catch(Exception e)
        {
            _estado=false;
            System.out.println("Error llenando xml :"+e.getMessage());
        }
        finally{ System.out.println("Generaro Xml correcto..."); }
        return _estado;
    }
    public void GenerarFirma()
    {
        try
        {
                XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
                Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, null),Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),null,null);
                SignedInfo _si =fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec)null),fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
                KeyStore ks =KeyStore.getInstance("JKS");
                ks.load(new FileInputStream(Ruta.rutaCertificado),"estacionsanjose16".toCharArray());
                KeyStore.PrivateKeyEntry keyentry= (KeyStore.PrivateKeyEntry) ks.getEntry("sanjose16", new KeyStore.PasswordProtection("estacionsanjose16".toCharArray()));
                X509Certificate cert =(X509Certificate) keyentry.getCertificate();
                //--------------------------------------------------------------------------probando cambios---------------------
                KeyInfoFactory kin = fac.getKeyInfoFactory();
                List x509Content = new ArrayList();
                x509Content.add(cert.getSubjectX500Principal().getName());
                x509Content.add(cert);
                X509Data xd = kin.newX509Data(x509Content);
                KeyInfo ki = kin.newKeyInfo(Collections.singletonList(xd));
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);
                org.w3c.dom.Document doc = dbf.newDocumentBuilder().parse(inputxml);

                Node _nodo = doc.getDocumentElement().getFirstChild().getLastChild().getFirstChild();
                DOMSignContext dsc = new DOMSignContext(keyentry.getPrivateKey(),_nodo);
                dsc.setDefaultNamespacePrefix("ds");                
                XMLSignature signature = fac.newXMLSignature(_si, ki,null,"SUNATID",null);                
                signature.sign(dsc);
                OutputStream os = new FileOutputStream(rutaXml);
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer trans = tf.newTransformer();
                trans.transform(new DOMSource(doc), new StreamResult(os));      
        }
        catch(Exception e)
        { System.out.println("Error firmando :"+e.getMessage());}
    }
    public boolean Envio()
    {
        boolean _rpta=true;
        try
        {  if(fa2.isFile())
            {
                _envioSunat = new Envio(getEempresa().getEmp_cusuario(), getEempresa().getEmp_cclave(), fa2);
                if(_envioSunat.enviarResumenDiario())
                    System.out.println("Termino Correcto :");
                    //_rpta= (LeerR(_envioSunat.strRutaResultado));
            } 
        }
        catch(Exception e)
        {System.out.println("Problemas en el envio :"+e.getMessage());}
        return _rpta;
    }

    public EEmpresa getEempresa() {
        return _eempresa;
    }
        
    
    
}
