
package Utilidad;

import AccessoDato.ECliente;
import AccessoDato.EEmpresa;
import AccessoDato.EFactura;
import AccessoDato.EFacturaDetalle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.AddressType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.AttachmentType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.CustomerPartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.DocumentReferenceType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.InvoiceLineType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.ItemType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.MonetaryTotalType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PartyLegalEntityType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PriceType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PricingReferenceType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.SignatureType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.SupplierPartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxCategoryType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxSchemeType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxSubtotalType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxTotalType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.ChargeTotalAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.DocumentCurrencyCodeType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.InvoiceTypeCodeType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.InvoicedQuantityType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.LineExtensionAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.PayableAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.PriceAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.TaxAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonExtensionComponents2.ExtensionContentType;
import oasisNamesSpecificationUblSchemaXsdCommonExtensionComponents2.UBLExtensionsType;
import oasisNamesSpecificationUblSchemaXsdInvoice2.InvoiceDocument;
import oasisNamesSpecificationUblSchemaXsdInvoice2.InvoiceType;
import org.apache.xmlbeans.XmlCursor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sunat.Envio;
import sunatNamesSpecificationUblPeruSchemaXsdSunatAggregateComponents1.AdditionalInformationDocument;
import sunatNamesSpecificationUblPeruSchemaXsdSunatAggregateComponents1.AdditionalInformationType;
import sunatNamesSpecificationUblPeruSchemaXsdSunatAggregateComponents1.AdditionalMonetaryTotalType;
import unUneceUncefactCodelistSpecification542172001.CurrencyCodeContentType;
import unUneceUncefactCodelistSpecification664112001.UnitCodeContentType;

public class GenerarXmml {
    
    private InvoiceDocument d;
    InvoiceType f;
    String rutaXml="";
    String rutazip="";
    File fa =null;
    File fa2=null;
    ExtensionContentType _nodoFirma;
    private Envio _envioSunat;
    private EFactura _efactura;
    private List<EFacturaDetalle>  _lsdetfactura;
    private String strUsuario;
    private String strClave;
    private boolean _estado;
    public String errReferenceID= "";
    public String errResponseCode= "";
    public String errDescription="";
    private EEmpresa _eempresa;
    private ECliente _ecliente;
    ExtensionContentType _extensiontype;
    AdditionalInformationType _addtypeinfo;
    InputStream inputxml;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Formato _fmd;
    public GenerarXmml()
    {
        _fmd = new Formato();
    }
    private void addUBLExtensions()
    {
        try
        {
            UBLExtensionsType _ubltype= f.addNewUBLExtensions();//--------------------------Tag principales
             _nodoFirma =_ubltype.addNewUBLExtension().addNewExtensionContent();//----------Tag para firma digital
             _ubltype.addNewUBLExtension().addNewExtensionContent(); //---------------------Tag para Additionalinformation             
        }
        catch(Exception e)
        {System.out.println("Creacion Tag principales UBLExtensions :"+e.getMessage());}
    }
    private void addDespatchDocumentReference()//----------------------Tipo y numero de documento de la guia remision complementario
    {
        try
        {
             DocumentReferenceType _documentreference=f.addNewDespatchDocumentReference();
             _documentreference.addNewID().setStringValue(_efactura.getDoc_ccodigo().equals("03")?"":"F001-1");
             _documentreference.addNewDocumentTypeCode().setStringValue(_efactura.getDoc_ccodigo().equals("03")?"":"09");
        }
        catch(Exception e)
        { System.out.println("Creacion Tag DespatchDocumentReference :"+e.getMessage());}
    }
    private void addAdditionaldocumentReference()
    {
        try
        {
            DocumentReferenceType _additionaldocumentreference =f.addNewAdditionalDocumentReference();
            _additionaldocumentreference.addNewID().setStringValue("0000");
            _additionaldocumentreference.addNewDocumentTypeCode().setStringValue("01");
        }
        catch(Exception e)
        {System.out.println("Creacion Tag AdditionalDocumentReference :"+e.getMessage());}
    }
    private void addSignature()
    {
        try
        {
            SignatureType _sigtype=f.addNewSignature();
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
            SupplierPartyType _addacountingsupplierparty= f.addNewAccountingSupplierParty();
             _addacountingsupplierparty.addNewCustomerAssignedAccountID().setStringValue(getEempresa().getEmp_cruc());
             _addacountingsupplierparty.addNewAdditionalAccountID().setStringValue(getEempresa().getDoi_ccodigo());             
             PartyType _party=_addacountingsupplierparty.addNewParty();
             _party.addNewPartyName().addNewName().setStringValue(".");
             AddressType _addpostaladdress=_party.addNewPostalAddress();
             _addpostaladdress.addNewID().setStringValue(getEempresa().getCodigoubigeo());//ubigeo
             _addpostaladdress.addNewStreetName().setStringValue(getEempresa().getDireccionsucursal());
             _addpostaladdress.addNewCitySubdivisionName().setStringValue(getEempresa().getDistrito());
             _addpostaladdress.addNewCityName().setStringValue(getEempresa().getDepartamento());
             _addpostaladdress.addNewCountrySubentity().setStringValue(getEempresa().getProvincia());
             _addpostaladdress.addNewDistrict().setStringValue(getEempresa().getDistrito());
             _addpostaladdress.addNewCountry().addNewIdentificationCode().setStringValue("PE");
             PartyLegalEntityType _legaenty=_party.addNewPartyLegalEntity();
             _legaenty.addNewRegistrationName().setStringValue(getEempresa().getEmp_cnombre());
        }
        catch(Exception e)
        {System.out.println("Creacion Tag AddAccountingSiplierParty :"+e.getMessage());}
    }
    private void addAccountingCustomerParty()//--------------------------------------------------------------------------Datos del adquiriente
    {
        try
        {
            CustomerPartyType _addaccountingcustomerparty= f.addNewAccountingCustomerParty();
            _addaccountingcustomerparty.addNewCustomerAssignedAccountID().setStringValue(getEcliente().getCli_cnumerodoc());
            _addaccountingcustomerparty.addNewAdditionalAccountID().setStringValue(getEcliente().getCoi_ccodigo());
            PartyType _addparty=_addaccountingcustomerparty.addNewParty();
            _addparty.addNewPartyLegalEntity().addNewRegistrationName().setStringValue(getEcliente().getCli_crazon());
            if(!_efactura.getDoc_ccodigo().equals("01"))
                 _addparty.addNewPhysicalLocation().addNewDescription().setStringValue("CALLE NUEVA");
        }
        catch(Exception e)
        {System.out.println("Creacion Tag AddAccountingcustomerParty :"+e.getMessage());}
    }
    private void addTaxTotal_IGV_ISC_OTR()
    {
        try
        {
             TaxTotalType _taxto =f.addNewTaxTotal();//------------------------------------------------------------------IGV
             TaxAmountType _taxamounttypecliente=_taxto.addNewTaxAmount();
             _taxamounttypecliente.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypecliente.setStringValue(String.valueOf(_efactura.getFac_igv()));
             TaxSubtotalType _taxsubtype= _taxto.addNewTaxSubtotal();
             _taxamounttypecliente=_taxsubtype.addNewTaxAmount();
             _taxamounttypecliente.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypecliente.setStringValue(String.valueOf(_efactura.getFac_igv()));
             TaxSchemeType _schematype=_taxsubtype.addNewTaxCategory().addNewTaxScheme();
             _schematype.addNewID().setStringValue("1000");//------------------------------------------------------------Catalogo 05
             _schematype.addNewName().setStringValue("IGV");
             _schematype.addNewTaxTypeCode().setStringValue("VAT");//----------------------------------------------------Catalogo 05
             TaxTotalType _taxtoISC =f.addNewTaxTotal();//---------------------------------------------------------------ISC
             TaxAmountType _taxamounttypeclienteISC=_taxtoISC.addNewTaxAmount();
             _taxamounttypeclienteISC.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteISC.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalisc())));
             TaxSubtotalType _taxsubtypeISC= _taxtoISC.addNewTaxSubtotal();
             _taxamounttypeclienteISC=_taxsubtypeISC.addNewTaxAmount();
             _taxamounttypeclienteISC.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteISC.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalisc())));
             _schematype=_taxsubtypeISC.addNewTaxCategory().addNewTaxScheme();
             _schematype.addNewID().setStringValue("2000");//------------------------------------------------------------Catalogo 05
             _schematype.addNewName().setStringValue("ISC");
             _schematype.addNewTaxTypeCode().setStringValue("EXC");//----------------------------------------------------Catalogo 05
             TaxTotalType _taxtootrsotri =f.addNewTaxTotal();//----------------------------------------------------------OTROS
             TaxAmountType _taxamounttypeclienteotrotri=_taxtootrsotri.addNewTaxAmount();
             _taxamounttypeclienteotrotri.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteotrotri.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalotrostributos())));
             TaxSubtotalType _taxsubtypeotrotri= _taxtootrsotri.addNewTaxSubtotal();
             _taxamounttypeclienteotrotri=_taxsubtypeotrotri.addNewTaxAmount();
             _taxamounttypeclienteotrotri.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteotrotri.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalotrostributos())));
             _schematype=_taxsubtypeotrotri.addNewTaxCategory().addNewTaxScheme();
             _schematype.addNewID().setStringValue("9999");//------------------------------------------------------------Catalogo 05
             _schematype.addNewName().setStringValue("OTROS TRIBUTOS");
             _schematype.addNewTaxTypeCode().setStringValue("OTH");//----------------------------------------------------Catalogo 05
        }catch(Exception e)
        {System.out.println("Creacion Tag AddTaxtotal :"+e.getMessage());}
    }
    private void addLegalMonetaryTotal()
    {
        try
        {
            MonetaryTotalType _legalmonetarytotal= f.addNewLegalMonetaryTotal();            
            PayableAmountType _payableamount=_legalmonetarytotal.addNewPayableAmount();
            _payableamount.setCurrencyID(CurrencyCodeContentType.PEN);//-------------------------------------------------Moneda total a pagar
            _payableamount.setStringValue(""+(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotal())));
        }catch(Exception e)
        {System.out.println("Creacion Tag AddLegalMonetaryTotal :"+e.getMessage());}
    }
    private void addInvoiceLine(int i)
    {
        try
        {
             InvoiceLineType _invoiceline=f.addNewInvoiceLine();
             _invoiceline.addNewID().setStringValue(""+(i+1));//-----------------------------------------------------------NUMERO ORDE DEL ITEM
             InvoicedQuantityType _quantitytype =_invoiceline.addNewInvoicedQuantity();
             _quantitytype.setUnitCode(UnitCodeContentType.CS);//----------------------------------------------------------UNIDAD MEDIDA
             _quantitytype.setStringValue(""+_lsdetfactura.get(i).getDfa_ccantidad());
             LineExtensionAmountType _extamounttype=  _invoiceline.addNewLineExtensionAmount();
             _extamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _extamounttype.setStringValue(""+_fmd.Farmat2DosDecimales(_lsdetfactura.get(i).getDfa_fvalorsubtotal()));//----CANTIDAD UNIDAD X ITEM
             //-------------------------------------------------------------VALORES UNITARIOS-----------------------------------------------------
             PricingReferenceType _preref =_invoiceline.addNewPricingReference();
             PriceType _conditionaltype=_preref.addNewAlternativeConditionPrice();
             PriceAmountType _priceamounttype=_conditionaltype.addNewPriceAmount();
             _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _priceamounttype.setStringValue(""+ _fmd.Farmat2DosDecimales(_lsdetfactura.get(i).getDfa_fvalorventa()));//------MONTO DEL VALOR UNITARIO
             _conditionaltype.addNewPriceTypeCode().setStringValue("01");//---------------------------------------------------CODIGO VALOR UNITARIO : CATALOGO 16
             //--------------------------------------IMPORTE TOTAL DE UN TIPO PARTICULAR DE IMPUESTO-----------------------------------------------
             TaxTotalType _taxtotalfinal= _invoiceline.addNewTaxTotal();
             TaxAmountType _taxamounttype=_taxtotalfinal.addNewTaxAmount();
             _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttype.setStringValue(""+_fmd.Farmat2DosDecimales((_lsdetfactura.get(i).getDfa_fvaloritemigv())));//------TOTAL IMPORTE         
             TaxSubtotalType _subtotalfinal=_taxtotalfinal.addNewTaxSubtotal();
             _taxamounttype=_subtotalfinal.addNewTaxAmount();
             _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttype.setStringValue(""+_fmd.Farmat2DosDecimales((_lsdetfactura.get(i).getDfa_fvaloritemigv())));
             TaxCategoryType _taxcategoriatype=_subtotalfinal.addNewTaxCategory();
             _taxcategoriatype.addNewTaxExemptionReasonCode().setStringValue(""+_lsdetfactura.get(i).getPve_ctipoafectacion());//-10 CATALOGO 07 CODIGO DE TIPO DE AFECTACIO DEL IGV
//                     _taxcategoriatype.addNewTierRange().setStringValue("02");//-----------------------Opcional
             TaxSchemeType _taxchemetype=_taxcategoriatype.addNewTaxScheme();
             _taxchemetype.addNewID().setStringValue("1000");//--------------------------------------------------------------------ID
             _taxchemetype.addNewName().setStringValue("IGV");
             _taxchemetype.addNewTaxTypeCode().setStringValue("VAT");
             //-------------------------------------------ITEM---------------------------------------------------------------------------
             ItemType _itemtype=_invoiceline.addNewItem();
             _itemtype.addNewDescription().setStringValue(""+_lsdetfactura.get(i).getArt_cdescripcion());
             _itemtype.addNewSellersItemIdentification().addNewID().setStringValue(""+_lsdetfactura.get(i).getArt_ncodarticulo());
             PriceType _typepreci=_invoiceline.addNewPrice();
             _priceamounttype=_typepreci.addNewPriceAmount();
             _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _priceamounttype.setStringValue(""+_fmd.Farmat2DosDecimales(_lsdetfactura.get(i).getDfa_fvalorunitario()));
        }catch(Exception e)
        {System.out.println("Creacion Tag InvoiceLine "+e.getMessage());}
    }
    private void addTagHeader()
    {
        try
        {
            XmlCursor _cursor=   f.newCursor();
            _cursor.toNextToken();
            _cursor.insertNamespace(null,"urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
            _cursor.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
            _cursor.insertNamespace("cac", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
            _cursor.insertNamespace("ext","urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
            _cursor.insertNamespace("ccts","urn:oasis:names:specification:ubl:schema:xsd:CoreComponentParameters-2");//---------TAG EXTRAS
            _cursor.insertNamespace("qdt","urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
            _cursor.insertNamespace("stat","urn:oasis:names:specification:ubl:schema:xsd:DocumentStatusCode-1.0");
            _cursor.insertNamespace("udt","urn:un:unece:uncefact:data:draft:UnqualifiedDataTypesSchemaModule:2");//-------------FIN TAG
            _cursor.insertNamespace("ds","http://www.w3.org/2000/09/xmldsig#");
            _cursor.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
        }
        catch(Exception e)
        {}
    }
    private void addNamesFile()
    {
        try
        {
            rutaXml= "d:\\Facturacion\\"+_eempresa.getEmp_cruc()+"-"+_efactura.getDoc_ccodigo()+"-"+_efactura.getFac_cserie()+"-"+_efactura.getFac_cnumero()+".xml";
            rutazip="d:\\Facturacion\\"+_eempresa.getEmp_cruc()+"-"+_efactura.getDoc_ccodigo()+"-"+_efactura.getFac_cserie()+"-"+_efactura.getFac_cnumero()+".zip";
            fa= new File(rutaXml);
        }
        catch(Exception e)
        {System.out.println("Error al definir files:"+e.getMessage());}
    }
    private AdditionalInformationDocument addAdditionalinformation()
    {
        AdditionalInformationDocument _additionalinformation=AdditionalInformationDocument.Factory.newInstance();
        try
        {
             XmlCursor _cursor2= _additionalinformation.newCursor();
             _cursor2.toNextToken();
             _cursor2.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
             _cursor2.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");             
             _addtypeinfo=_additionalinformation.addNewAdditionalInformation();
             AdditionalMonetaryTotalType _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1001");///////////////////////////////CASO 1001
             PayableAmountType _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
             _addpayamounttypeinfo.setStringValue(""+_efactura.getFac_fimportesubtotal());
             _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1002");//////////////////////////////////CASO 1002
             _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
             _addpayamounttypeinfo.setStringValue(""+_efactura.getFac_ftotalinafecto());
             _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1003");//////////////////////////////////CASO 1003
             _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
             _addpayamounttypeinfo.setStringValue(""+_efactura.getFac_ftotalexonerado());
             _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1004");//////////////////////////////////CASO 1004
             _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
             _addpayamounttypeinfo.setStringValue("0.0");
        }
        catch(Exception e)
        {System.out.println("Creacion Tag principales AddtitionInformation "+e.getMessage());}
        return _additionalinformation;
    }
    private void addMergeDocumentXml(AdditionalInformationDocument x_additionalinformationdocument)
    {
        try
        {
             DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
             DocumentBuilder db=null;
             Document docinvoice=null;
             Document docinfoadd=null;
             db= dbf.newDocumentBuilder();
             docinvoice =db.parse(d.newInputStream());
             docinfoadd=db.parse(x_additionalinformationdocument.newInputStream());
             Node _nodeAdd = docinvoice.importNode(docinfoadd.getElementsByTagName("sac:AdditionalInformation").item(0), true);
             Node ndListdoc =docinvoice.getElementsByTagName("ext:ExtensionContent").item(0);
             ndListdoc.appendChild(_nodeAdd);
             TransformerFactory tFactory = TransformerFactory.newInstance();
             Transformer transformer = tFactory.newTransformer();
             transformer.setOutputProperty(OutputKeys.INDENT, "yes");            
             DOMSource source = new DOMSource(docinvoice);             
             StreamResult result = new StreamResult(new StringWriter());
             transformer.transform(source, result); 
             ByteArrayOutputStream _salidaxml= new ByteArrayOutputStream();//----------------------------------Salida InputStream
             Result outtarge= new StreamResult(_salidaxml);
             TransformerFactory.newInstance().newTransformer().transform(source, outtarge);
             inputxml=new ByteArrayInputStream(_salidaxml.toByteArray());
        }
        catch(Exception e)
        {System.out.println("Error union de documentos:"+e.getMessage());}
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
            d= InvoiceDocument.Factory.newInstance();
            f = d.addNewInvoice();
            addTagHeader();
            d.documentProperties().setEncoding("ISO-8859-1");
            d.documentProperties().setStandalone(false);
            f.addNewIssueDate().setStringValue(dateFormat.format(_efactura.getFac_dfechaemision()));//-----------Fecha de emision del comproante 
            addUBLExtensions();
            f.addNewUBLVersionID().setStringValue("2.0");///-----------------------------------------------------Version del Esquema UBL
            f.addNewCustomizationID().setStringValue("1.0");//---------------------------------------------------Version del documento
            f.addNewID().setStringValue(_efactura.getFac_cserie()+"-"+_efactura.getFac_cnumero());//-------------Serie y numero de Documento
            InvoiceTypeCodeType _typcode= f.addNewInvoiceTypeCode();
            _typcode.setStringValue(_efactura.getDoc_ccodigo());//-----------------------------------------------Codigo del Tipo Documento
            DocumentCurrencyCodeType _doctype=f.addNewDocumentCurrencyCode();
            _doctype.setStringValue(_efactura.getMon_ccodigo());//-----------------------------------------------Moneda en la que se emite el Documento
            addDespatchDocumentReference();
            addAdditionaldocumentReference();
            addSignature();
            addAccountingSuplierParty();
            addAccountingCustomerParty();
            addTaxTotal_IGV_ISC_OTR();
            addLegalMonetaryTotal();
            for (int i=0;i<=_lsdetfactura.size()-1;i++)
            {addInvoiceLine(i);}
            AdditionalInformationDocument _informationdocument=addAdditionalinformation();
            addMergeDocumentXml(_informationdocument);
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
    
    public boolean LlenarXMltoEntity()
    {
         try
            {
             rutaXml= "d:\\Facturacion\\"+_eempresa.getEmp_cruc()+"-"+_efactura.getDoc_ccodigo()+"-"+_efactura.getFac_cserie()+"-"+_efactura.getFac_cnumero()+".xml";
             rutazip="d:\\Facturacion\\"+_eempresa.getEmp_cruc()+"-"+_efactura.getDoc_ccodigo()+"-"+_efactura.getFac_cserie()+"-"+_efactura.getFac_cnumero()+".zip";
             fa= new File(rutaXml);
             d= InvoiceDocument.Factory.newInstance();             
             f = d.addNewInvoice();
              XmlCursor _cursor=   f.newCursor();  
             _cursor.toNextToken();
             _cursor.insertNamespace(null,"urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
             _cursor.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
             _cursor.insertNamespace("cac", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
             _cursor.insertNamespace("ext","urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
             /////////////////////////////////////////////////////////TAG EXTRAS ////////////////////////////////
             _cursor.insertNamespace("ccts","urn:oasis:names:specification:ubl:schema:xsd:CoreComponentParameters-2");
             _cursor.insertNamespace("qdt","urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
             _cursor.insertNamespace("stat","urn:oasis:names:specification:ubl:schema:xsd:DocumentStatusCode-1.0");
             _cursor.insertNamespace("udt","urn:un:unece:uncefact:data:draft:UnqualifiedDataTypesSchemaModule:2");
             //////////////////////////////////////////////////////////FIN DE TAG EXTRAS///////////////////////////
             _cursor.insertNamespace("ds","http://www.w3.org/2000/09/xmldsig#");
             _cursor.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
             d.documentProperties().setEncoding("ISO-8859-1");
             d.documentProperties().setStandalone(false);  
//             DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             f.addNewIssueDate().setStringValue(dateFormat.format(_efactura.getFac_dfechaemision()));             
             UBLExtensionsType _ubltype= f.addNewUBLExtensions();
             ////////////////////////////////////////////////////LA SIGUIENTE LINEA SOLO SE DECLARA LA FIRMA DIGITAL/////////////////////////////
             _nodoFirma =_ubltype.addNewUBLExtension().addNewExtensionContent();
             _ubltype.addNewUBLExtension().addNewExtensionContent();
             ////////////////////////FIN DE LA LINEA DE FIRMA DIGITAL////////////////////////////////////////////////////////////////////////////             
             f.addNewUBLVersionID().setStringValue("2.0");/////////////////////////////////////////////////VERSION DEL ESQUEMA UBL -NO MODIFICAR ESTATICO
             f.addNewCustomizationID().setStringValue("1.0");/////////////////////////////////////////////VERSION DE LA ESTRUCTURA DEL COCUMENTO  -NO MODIFICAR ESTATICO
             f.addNewID().setStringValue(_efactura.getFac_cserie()+"-"+_efactura.getFac_cnumero());/////////////////////////////////////////////////////SERIE Y NUMERO-VARIABLE
             InvoiceTypeCodeType _typcode= f.addNewInvoiceTypeCode();
            _typcode.setStringValue(_efactura.getDoc_ccodigo());//////////////////////////////////////////////////////////////
             DocumentCurrencyCodeType _doctype=f.addNewDocumentCurrencyCode();/////////////////////////TIPO MONEDA EN QUE SE EMITE FACTURA -VARIABLE
             _doctype.setStringValue(_efactura.getMon_ccodigo());
             //------------------------------------------------------------GUIA REMISION------------------------------------------------------
             DocumentReferenceType _docref=f.addNewDespatchDocumentReference();
             _docref.addNewID().setStringValue("F001-1");
             _docref.addNewDocumentTypeCode().setStringValue("09");
             DocumentReferenceType _docaddref =f.addNewAdditionalDocumentReference();
             _docaddref.addNewID().setStringValue("0000");
             _docaddref.addNewDocumentTypeCode().setStringValue("01");
             //----------------------------------------------------------EMISOR----------------------------------------------------------------
             SignatureType _sigtype=f.addNewSignature();
             _sigtype.addNewID().setStringValue("IDSignKG");
             PartyType _party=_sigtype.addNewSignatoryParty();
             _party.addNewPartyIdentification().addNewID().setStringValue(getEempresa().getEmp_cruc());
             _party.addNewPartyName().addNewName().setStringValue(getEempresa().getEmp_cnombre());             
             AttachmentType _atttype=_sigtype.addNewDigitalSignatureAttachment();
             _atttype.addNewExternalReference().addNewURI().setStringValue("#signatureKG");             
             SupplierPartyType _supptye= f.addNewAccountingSupplierParty();
             _supptye.addNewCustomerAssignedAccountID().setStringValue(getEempresa().getEmp_cruc());
             _supptye.addNewAdditionalAccountID().setStringValue(getEempresa().getDoi_ccodigo());             
             PartyType _aprtype=_supptye.addNewParty();
             _aprtype.addNewPartyName().addNewName().setStringValue(".");
             AddressType _addtype=_aprtype.addNewPostalAddress();
             _addtype.addNewID().setStringValue(getEempresa().getCodigoubigeo());//ubigeo
             _addtype.addNewStreetName().setStringValue(getEempresa().getDireccionsucursal());
             _addtype.addNewCitySubdivisionName().setStringValue(getEempresa().getDistrito());
             _addtype.addNewCityName().setStringValue(getEempresa().getDepartamento());
             _addtype.addNewCountrySubentity().setStringValue(getEempresa().getProvincia());
             _addtype.addNewDistrict().setStringValue(getEempresa().getDistrito());
             _addtype.addNewCountry().addNewIdentificationCode().setStringValue("PE");
             PartyLegalEntityType _legaenty=_aprtype.addNewPartyLegalEntity();
             _legaenty.addNewRegistrationName().setStringValue(getEempresa().getEmp_cnombre());
              //--------------------------------------------------------------------------------ADQUIRIENTE---------------------------------------------                                              
             CustomerPartyType _custype= f.addNewAccountingCustomerParty();
             _custype.addNewCustomerAssignedAccountID().setStringValue(getEcliente().getCli_cnumerodoc());
             _custype.addNewAdditionalAccountID().setStringValue(getEcliente().getCoi_ccodigo());
             PartyType _adquiriente=_custype.addNewParty();
             _adquiriente.addNewPartyLegalEntity().addNewRegistrationName().setStringValue(getEcliente().getCli_crazon());
             //------------------------------------------------------IMPUESTOS GLOBALES-------------------------------------------------------
             TaxTotalType _taxto =f.addNewTaxTotal();
             TaxAmountType _taxamounttypecliente=_taxto.addNewTaxAmount();
             _taxamounttypecliente.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypecliente.setStringValue(String.valueOf(_efactura.getFac_igv()));
             TaxSubtotalType _taxsubtype= _taxto.addNewTaxSubtotal();
             _taxamounttypecliente=_taxsubtype.addNewTaxAmount();
             _taxamounttypecliente.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypecliente.setStringValue(String.valueOf(_efactura.getFac_igv()));
             TaxSchemeType _schematype=_taxsubtype.addNewTaxCategory().addNewTaxScheme();
             _schematype.addNewID().setStringValue("1000");////////////////////////////////////////////CATALOGO 05-TIPO DE TRIBUTO
             _schematype.addNewName().setStringValue("IGV");
             _schematype.addNewTaxTypeCode().setStringValue("VAT");////////////////////////////////////FIN CATALOGO 05
             
             //------------------------------------------------------------------------------------ISC
             TaxTotalType _taxtoISC =f.addNewTaxTotal();
             TaxAmountType _taxamounttypeclienteISC=_taxtoISC.addNewTaxAmount();
             _taxamounttypeclienteISC.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteISC.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalisc())));
             TaxSubtotalType _taxsubtypeISC= _taxtoISC.addNewTaxSubtotal();
             _taxamounttypeclienteISC=_taxsubtypeISC.addNewTaxAmount();
             _taxamounttypeclienteISC.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteISC.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalisc())));
             _schematype=_taxsubtypeISC.addNewTaxCategory().addNewTaxScheme();
             _schematype.addNewID().setStringValue("2000");////////////////////////////////////////////CATALOGO 05-TIPO DE TRIBUTO
             _schematype.addNewName().setStringValue("ISC");
             _schematype.addNewTaxTypeCode().setStringValue("EXC");////////////////////////////////////FIN CATALOGO 05
             //------------------------------------------------------------------------------------OTROS
             TaxTotalType _taxtootrsotri =f.addNewTaxTotal();
             TaxAmountType _taxamounttypeclienteotrotri=_taxtootrsotri.addNewTaxAmount();
             _taxamounttypeclienteotrotri.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteotrotri.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalotrostributos())));
             TaxSubtotalType _taxsubtypeotrotri= _taxtootrsotri.addNewTaxSubtotal();
             _taxamounttypeclienteotrotri=_taxsubtypeotrotri.addNewTaxAmount();
             _taxamounttypeclienteotrotri.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypeclienteotrotri.setStringValue(String.valueOf(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotalotrostributos())));
             _schematype=_taxsubtypeotrotri.addNewTaxCategory().addNewTaxScheme();
             _schematype.addNewID().setStringValue("9999");////////////////////////////////////////////CATALOGO 05-TIPO DE TRIBUTO
             _schematype.addNewName().setStringValue("OTROS TRIBUTOS");
             _schematype.addNewTaxTypeCode().setStringValue("OTH");////////////////////////////////////FIN CATALOGO 05
             //------------------------------------------------------------------------------------------------------------------
             MonetaryTotalType _legalmonetarytotal= f.addNewLegalMonetaryTotal();            
             PayableAmountType _payableamount=_legalmonetarytotal.addNewPayableAmount();
             _payableamount.setCurrencyID(CurrencyCodeContentType.PEN);//-------------------------------------------------Moneda total a pagar
             _payableamount.setStringValue(""+(_fmd.Farmat2DosDecimales(_efactura.getFac_ftotal())));
             //-----------------------------------------------------------ITEM FACTURA----------------------------------------------------
             //------------------------------------------------------------DETALLE--------------------------------------------
             for (int i=0;i<=_lsdetfactura.size()-1;i++)
             {
                     InvoiceLineType _invoiceline=f.addNewInvoiceLine();
                     _invoiceline.addNewID().setStringValue(""+(i+1));/////////////////////////////////////NUMERO ORDE DEL ITEM
                     InvoicedQuantityType _quantitytype =_invoiceline.addNewInvoicedQuantity();
                     _quantitytype.setUnitCode(UnitCodeContentType.CS);//////////////////////////////UNIDAD MEDIDA
                     _quantitytype.setStringValue(""+_lsdetfactura.get(i).getDfa_ccantidad());
                     LineExtensionAmountType _extamounttype=  _invoiceline.addNewLineExtensionAmount();
                     _extamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                     _extamounttype.setStringValue(""+_fmd.Farmat2DosDecimales(_lsdetfactura.get(i).getDfa_fvalorsubtotal()));//----------------------------------CANTIDAD UNIDAD X ITEM
                     ////////////////////////////VALORES UNITARIOS////////////////
                     PricingReferenceType _preref =_invoiceline.addNewPricingReference();
                     PriceType _conditionaltype=_preref.addNewAlternativeConditionPrice();
                     PriceAmountType _priceamounttype=_conditionaltype.addNewPriceAmount();
                     _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                     _priceamounttype.setStringValue(""+ _fmd.Farmat2DosDecimales(_lsdetfactura.get(i).getDfa_fvalorventa()));//(_lsdetfactura.get(i).getDfa_fvalorunitario()+_lsdetfactura.get(i).getDfa_fvaloritemigv()));///////////////////////////////////////MONTO DEL VALOR UNITARIO
                     _conditionaltype.addNewPriceTypeCode().setStringValue("01");////////////////////CODIGO VALOR UNITARIO : CATALOGO 16
                     ////////////IMPORTE TOTAL DE UN TIPO PARTICULAR DE IMPUESTO//////////////////////////////////////////////
                     TaxTotalType _taxtotalfinal= _invoiceline.addNewTaxTotal();
                     TaxAmountType _taxamounttype=_taxtotalfinal.addNewTaxAmount();
                     _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                     _taxamounttype.setStringValue(""+_fmd.Farmat2DosDecimales((_lsdetfactura.get(i).getDfa_fvaloritemigv())));////////////////////////////////////////TOTAL IMPORTE         
                     TaxSubtotalType _subtotalfinal=_taxtotalfinal.addNewTaxSubtotal();
                     _taxamounttype=_subtotalfinal.addNewTaxAmount();
                     _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                     _taxamounttype.setStringValue(""+_fmd.Farmat2DosDecimales((_lsdetfactura.get(i).getDfa_fvaloritemigv())));
                     TaxCategoryType _taxcategoriatype=_subtotalfinal.addNewTaxCategory();
                     _taxcategoriatype.addNewTaxExemptionReasonCode().setStringValue(""+_lsdetfactura.get(i).getPve_ctipoafectacion());///////////10 CATALOGO 07 CODIGO DE TIPO DE AFECTACIO DEL IGV
//                     _taxcategoriatype.addNewTierRange().setStringValue("02");//-----------------------Opcional
                     TaxSchemeType _taxchemetype=_taxcategoriatype.addNewTaxScheme();
                     _taxchemetype.addNewID().setStringValue("1000");///////////////////////////////////ID
                     _taxchemetype.addNewName().setStringValue("IGV");
                     _taxchemetype.addNewTaxTypeCode().setStringValue("VAT");
                     ///////////////////ITEM//////////////////////////////////////////
                     ItemType _itemtype=_invoiceline.addNewItem();
                     _itemtype.addNewDescription().setStringValue(""+_lsdetfactura.get(i).getArt_cdescripcion());
                     _itemtype.addNewSellersItemIdentification().addNewID().setStringValue(""+_lsdetfactura.get(i).getArt_ncodarticulo());
                     PriceType _typepreci=_invoiceline.addNewPrice();
                     _priceamounttype=_typepreci.addNewPriceAmount();
                     _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
                     _priceamounttype.setStringValue(""+_fmd.Farmat2DosDecimales(_lsdetfactura.get(i).getDfa_fvalorunitario()));
             }
             //------------------------------------------------------------FIN DETALLE-----------------------------------------
             
             
             //-------------------------------------------------------Informacion Adicional--------------------------------------
             AdditionalInformationDocument _infodoc=AdditionalInformationDocument.Factory.newInstance();
             XmlCursor _cursor2= _infodoc.newCursor();
             _cursor2.toNextToken();
             _cursor2.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
             _cursor2.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");             
             _addtypeinfo=_infodoc.addNewAdditionalInformation();
             AdditionalMonetaryTotalType   _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1001");///////////////////////////////CASO 1001
             PayableAmountType _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue(""+_efactura.getFac_fimportesubtotal());
            _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
            _typemonetaryaddinfo.addNewID().setStringValue("1002");//////////////////////////////////CASO 1002
            _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
            _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue(""+_efactura.getFac_ftotalinafecto());
            _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
            _typemonetaryaddinfo.addNewID().setStringValue("1003");//////////////////////////////////CASO 1003
            _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
            _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue(""+_efactura.getFac_ftotalexonerado());
            _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
            _typemonetaryaddinfo.addNewID().setStringValue("1004");//////////////////////////////////CASO 1004
            _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
            _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue("0.0");
             //-------------------------------------------------------------------XML----------------------------------------
             DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
             DocumentBuilder db=null;
             Document docinvoice=null;
             Document docinfoadd=null;
             db= dbf.newDocumentBuilder();
             docinvoice =db.parse(d.newInputStream());
             docinfoadd=db.parse(_infodoc.newInputStream());
             Node _nodeAdd = docinvoice.importNode(docinfoadd.getElementsByTagName("sac:AdditionalInformation").item(0), true);
             Node ndListdoc =docinvoice.getElementsByTagName("ext:ExtensionContent").item(0);
             ndListdoc.appendChild(_nodeAdd);
             TransformerFactory tFactory = TransformerFactory.newInstance();
             Transformer transformer = tFactory.newTransformer();
             transformer.setOutputProperty(OutputKeys.INDENT, "yes");            
             DOMSource source = new DOMSource(docinvoice);             
             StreamResult result = new StreamResult(new StringWriter());
             transformer.transform(source, result); 
             ///inpustream
             ByteArrayOutputStream _salidaxml= new ByteArrayOutputStream();
             Result outtarge= new StreamResult(_salidaxml);
             TransformerFactory.newInstance().newTransformer().transform(source, outtarge);
             inputxml=new ByteArrayInputStream(_salidaxml.toByteArray());
//             Writer output = new BufferedWriter(new FileWriter("D:\\15072016-3.xml"));
//             String xmlOutput = result.getWriter().toString();  
//             output.write(xmlOutput);
//             output.close();
//----------------VERSION ANTIGUA FUNCIONA
//             if(fa.isFile())
//                 fa.delete();
//             fa.createNewFile();                         
//             d.save(fa); 
//----------------FIN VERSION ANTIGUA
            GenerarFirma();
            //---------------------------------------------GENERACION DE ARCHIVO ZIP  ----------------------------------------------------
             fa2= new File(rutazip);//////ZIP
             if(fa2.isFile())
                 fa2.delete();
             //fa.createNewFile();
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
                _estado=true;
            }
            catch(Exception e)
            {
                _estado=false;
                System.out.println("Error creando zip:"+e.getMessage());
            }
            finally{
                System.out.println("Generaro Xml correcto...");
            }              
            return _estado;
    }
    public boolean LlenarXMl()//ejeplo de carga xml estatico
    {
        
         try
            {
             d= InvoiceDocument.Factory.newInstance();             
             f = d.addNewInvoice();
              XmlCursor _cursor=   f.newCursor();  
             _cursor.toNextToken();
             _cursor.insertNamespace(null,"urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
             _cursor.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
             _cursor.insertNamespace("cac", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
             _cursor.insertNamespace("ext","urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
             /////////////////////////////////////////////////////////TAG EXTRAS ////////////////////////////////
             _cursor.insertNamespace("ccts","urn:oasis:names:specification:ubl:schema:xsd:CoreComponentParameters-2");
             _cursor.insertNamespace("qdt","urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
             _cursor.insertNamespace("stat","urn:oasis:names:specification:ubl:schema:xsd:DocumentStatusCode-1.0");
             _cursor.insertNamespace("udt","urn:un:unece:uncefact:data:draft:UnqualifiedDataTypesSchemaModule:2");
             //////////////////////////////////////////////////////////FIN DE TAG EXTRAS///////////////////////////
             _cursor.insertNamespace("ds","http://www.w3.org/2000/09/xmldsig#");
             _cursor.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
             d.documentProperties().setEncoding("ISO-8859-1");
             d.documentProperties().setStandalone(false);            
             f.addNewIssueDate().setStringValue("2016-07-15");             
             UBLExtensionsType _ubltype= f.addNewUBLExtensions();
             ////////////////////////////////////////////////////LA SIGUIENTE LINEA SOLO SE DECLARA LA FIRMA DIGITAL/////////////////////////////
             _nodoFirma =_ubltype.addNewUBLExtension().addNewExtensionContent();
             _ubltype.addNewUBLExtension().addNewExtensionContent();
             ////////////////////////FIN DE LA LINEA DE FIRMA DIGITAL////////////////////////////////////////////////////////////////////////////             
             f.addNewUBLVersionID().setStringValue("2.0");/////////////////////////////////////////////////VERSION DEL ESQUEMA UBL -NO MODIFICAR ESTATICO
             f.addNewCustomizationID().setStringValue("1.0");/////////////////////////////////////////////VERSION DE LA ESTRUCTURA DEL COCUMENTO  -NO MODIFICAR ESTATICO
             f.addNewID().setStringValue("F001-01");/////////////////////////////////////////////////////SERIE Y NUMERO-VARIABLE
             InvoiceTypeCodeType _typcode= f.addNewInvoiceTypeCode();
            _typcode.setStringValue("01");//////////////////////////////////////////////////////////////
             DocumentCurrencyCodeType _doctype=f.addNewDocumentCurrencyCode();/////////////////////////TIPO MONEDA EN QUE SE EMITE FACTURA -VARIABLE
             _doctype.setStringValue("PEN");
             //------------------------------------------------------------GUIA REMISION------------------------------------------------------
             DocumentReferenceType _docref=f.addNewDespatchDocumentReference();
             _docref.addNewID().setStringValue("010101");
             _docref.addNewDocumentTypeCode().setStringValue("01");
             DocumentReferenceType _docaddref =f.addNewAdditionalDocumentReference();
             _docaddref.addNewID().setStringValue("0000");
             _docaddref.addNewDocumentTypeCode().setStringValue("01");
             //----------------------------------------------------------EMISOR----------------------------------------------------------------
             SignatureType _sigtype=f.addNewSignature();
             _sigtype.addNewID().setStringValue("IDSignKG");
             PartyType _party=_sigtype.addNewSignatoryParty();
             _party.addNewPartyIdentification().addNewID().setStringValue("20456047212");
             _party.addNewPartyName().addNewName().setStringValue("DigitalBox");             
             AttachmentType _atttype=_sigtype.addNewDigitalSignatureAttachment();
             _atttype.addNewExternalReference().addNewURI().setStringValue("#signatureKG");             
             SupplierPartyType _supptye= f.addNewAccountingSupplierParty();
             _supptye.addNewCustomerAssignedAccountID().setStringValue("20456047212");
             _supptye.addNewAdditionalAccountID().setStringValue("6");             
             PartyType _aprtype=_supptye.addNewParty();
             _aprtype.addNewPartyName().addNewName().setStringValue("...");
             AddressType _addtype=_aprtype.addNewPostalAddress();
             _addtype.addNewID().setStringValue("040104");//ubigeo
             _addtype.addNewStreetName().setStringValue("AV. ALFONSO UGARTE 913 E' 19 URB. LA LIBERTAD 4 CDRAS ARRIBA DE PLAZA LAS AMERICAS");
             _addtype.addNewCitySubdivisionName().setStringValue("Cerro colorado");
             _addtype.addNewCityName().setStringValue("AREQUIPA");
             _addtype.addNewCountrySubentity().setStringValue("AREQUIPA");
             _addtype.addNewDistrict().setStringValue("CERRO COLORADO");
             _addtype.addNewCountry().addNewIdentificationCode().setStringValue("PE");
             PartyLegalEntityType _legaenty=_aprtype.addNewPartyLegalEntity();
             _legaenty.addNewRegistrationName().setStringValue("DIGITAL BOX PERU SAC.");
              //--------------------------------------------------------------------------------ADQUIRIENTE---------------------------------------------                                              
             CustomerPartyType _custype= f.addNewAccountingCustomerParty();
             _custype.addNewCustomerAssignedAccountID().setStringValue("20228985237");
             _custype.addNewAdditionalAccountID().setStringValue("6");
             PartyType _adquiriente=_custype.addNewParty();
             _adquiriente.addNewPartyLegalEntity().addNewRegistrationName().setStringValue("DANIEL TRAVIEZO");
             //------------------------------------------------------IMPUESTOS GLOBALES-------------------------------------------------------
             TaxTotalType _taxto =f.addNewTaxTotal();
             TaxAmountType _taxamounttypecliente=_taxto.addNewTaxAmount();
             _taxamounttypecliente.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypecliente.setStringValue("26361.55");
             TaxSubtotalType _taxsubtype= _taxto.addNewTaxSubtotal();
             _taxamounttypecliente=_taxsubtype.addNewTaxAmount();
             _taxamounttypecliente.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttypecliente.setStringValue("26361.55");
             TaxSchemeType _schematype=_taxsubtype.addNewTaxCategory().addNewTaxScheme();
             _schematype.addNewID().setStringValue("1000");////////////////////////////////////////////CATALOGO 05-TIPO DE TRIBUTO
             _schematype.addNewName().setStringValue("IGV");
             _schematype.addNewTaxTypeCode().setStringValue("VAT");////////////////////////////////////FIN CATALOGO 05
             MonetaryTotalType _montotal= f.addNewLegalMonetaryTotal();
             //------------------------------------------------TOTAL  A PAGAR DE LA FACTURA Y CARGOS-------------------------------
             ChargeTotalAmountType _charguetotalamount =_montotal.addNewChargeTotalAmount();
             _charguetotalamount.setCurrencyID(CurrencyCodeContentType.PEN);////IMPORTE TOTAL DE LOS CARGOS APLICADOS AL TOTAL  DE LA FACTURA
             _charguetotalamount.setStringValue("30.50");             
             PayableAmountType _amounttype=_montotal.addNewPayableAmount();
             _amounttype.setCurrencyID(CurrencyCodeContentType.PEN);////////////MONEDA E IMPORTE TOTAL A PAGAR
             _amounttype.setStringValue("30.50");
             //-----------------------------------------------------------ITEM FACTURA----------------------------------------------------
             InvoiceLineType _invoiceline=f.addNewInvoiceLine();
             _invoiceline.addNewID().setStringValue("1");/////////////////////////////////////NUMERO ORDE DEL ITEM
             InvoicedQuantityType _quantitytype =_invoiceline.addNewInvoicedQuantity();
             _quantitytype.setUnitCode(UnitCodeContentType.CS);//////////////////////////////UNIDAD MEDIDA
             _quantitytype.setStringValue("300.0");
             LineExtensionAmountType _extamounttype=  _invoiceline.addNewLineExtensionAmount();
             _extamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _extamounttype.setStringValue("172890.0");////////////////////////////////////////////CANTIDAD UNIDAD X ITEM
             ////////////////////////////VALORES UNITARIOS////////////////
             PricingReferenceType _preref =_invoiceline.addNewPricingReference();
             PriceType _conditionaltype=_preref.addNewAlternativeConditionPrice();
             PriceAmountType _priceamounttype=_conditionaltype.addNewPriceAmount();
             _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _priceamounttype.setStringValue("18.75");///////////////////////////////////////MONTO DEL VALOR UNITARIO
             _conditionaltype.addNewPriceTypeCode().setStringValue("01");////////////////////CODIGO VALOR UNITARIO
             ////////////IMPORTE TOTAL DE UN TIPO PARTICULAR DE IMPUESTO//////////////////////////////////////////////
             TaxTotalType _taxtotalfinal= _invoiceline.addNewTaxTotal();
             TaxAmountType _taxamounttype=_taxtotalfinal.addNewTaxAmount();
             _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttype.setStringValue("8745.0");////////////////////////////////////////TOTAL IMPORTE         
             TaxSubtotalType _subtotalfinal=_taxtotalfinal.addNewTaxSubtotal();
             _taxamounttype=_subtotalfinal.addNewTaxAmount();
             _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _taxamounttype.setStringValue("8745.0");
             TaxCategoryType _taxcategoriatype=_subtotalfinal.addNewTaxCategory();
             _taxcategoriatype.addNewTaxExemptionReasonCode().setStringValue("10");
             _taxcategoriatype.addNewTierRange().setStringValue("02");
             TaxSchemeType _taxchemetype=_taxcategoriatype.addNewTaxScheme();
             _taxchemetype.addNewID().setStringValue("1000");///////////////////////////////////ID
             _taxchemetype.addNewName().setStringValue("IGV");
             _taxchemetype.addNewTaxTypeCode().setStringValue("VAT");
             ///////////////////ITEM//////////////////////////////////////////
             ItemType _itemtype=_invoiceline.addNewItem();
             _itemtype.addNewDescription().setStringValue("Arros");
             _itemtype.addNewSellersItemIdentification().addNewID().setStringValue("01");
             PriceType _typepreci=_invoiceline.addNewPrice();
             _priceamounttype=_typepreci.addNewPriceAmount();
             _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
             _priceamounttype.setStringValue("678.0");
             //-------------------------------------------------------Informacion Adicional--------------------------------------
             AdditionalInformationDocument _infodoc=AdditionalInformationDocument.Factory.newInstance();
             XmlCursor _cursor2= _infodoc.newCursor();
             _cursor2.toNextToken();
             _cursor2.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
             _cursor2.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");             
             _addtypeinfo=_infodoc.addNewAdditionalInformation();
             AdditionalMonetaryTotalType   _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1001");///////////////////////////////CASO 1001
             PayableAmountType _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue("3456.58");
            _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
            _typemonetaryaddinfo.addNewID().setStringValue("1002");//////////////////////////////////CASO 1002
            _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
            _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue("0.0");
            _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
            _typemonetaryaddinfo.addNewID().setStringValue("1003");//////////////////////////////////CASO 1003
            _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
            _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue("0.0");
            _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
            _typemonetaryaddinfo.addNewID().setStringValue("1004");//////////////////////////////////CASO 1004
            _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
            _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
            _addpayamounttypeinfo.setStringValue("0.0");
             //-------------------------------------------------------------------XML----------------------------------------
             DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
             DocumentBuilder db=null;
             Document docinvoice=null;
             Document docinfoadd=null;
             db= dbf.newDocumentBuilder();
             docinvoice =db.parse(d.newInputStream());
             docinfoadd=db.parse(_infodoc.newInputStream());
             Node _nodeAdd = docinvoice.importNode(docinfoadd.getElementsByTagName("sac:AdditionalInformation").item(0), true);
             Node ndListdoc =docinvoice.getElementsByTagName("ext:ExtensionContent").item(0);
             ndListdoc.appendChild(_nodeAdd);
             TransformerFactory tFactory = TransformerFactory.newInstance();
             Transformer transformer = tFactory.newTransformer();
             transformer.setOutputProperty(OutputKeys.INDENT, "yes");            
             DOMSource source = new DOMSource(docinvoice);             
             StreamResult result = new StreamResult(new StringWriter());
             transformer.transform(source, result); 
             ///inpustream
             ByteArrayOutputStream _salidaxml= new ByteArrayOutputStream();
             Result outtarge= new StreamResult(_salidaxml);
             TransformerFactory.newInstance().newTransformer().transform(source, outtarge);
             inputxml=new ByteArrayInputStream(_salidaxml.toByteArray());
//             Writer output = new BufferedWriter(new FileWriter("D:\\15072016-3.xml"));
//             String xmlOutput = result.getWriter().toString();  
//             output.write(xmlOutput);
//             output.close();
//----------------VERSION ANTIGUA FUNCIONA
//             if(fa.isFile())
//                 fa.delete();
//             fa.createNewFile();                         
//             d.save(fa); 
//----------------FIN VERSION ANTIGUA
            GenerarFirma();
            //---------------------------------------------GENERACION DE ARCHIVO ZIP  ----------------------------------------------------
             fa2= new File(rutazip);//////ZIP
             if(fa2.isFile())
                 fa2.delete();
             //fa.createNewFile();
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
                _estado=true;
            }
            catch(Exception e)
            {
                _estado=false;
                System.out.println("Error creando zip:"+e.getMessage());
            }
            finally{
                System.out.println("Generaro Xml correcto...");
            }              
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
                File fff = new File("D:\\CertificadoOriginal\\sanjosealias");//("d:\\sanjo.jks");
                fff.isFile();
                ks.load(new FileInputStream("D:\\CertificadoOriginal\\sanjosealias"),"estacionsanjose16".toCharArray());
                KeyStore.PrivateKeyEntry keyentry= (KeyStore.PrivateKeyEntry) ks.getEntry("sanjose16", new KeyStore.PasswordProtection("estacionsanjose16".toCharArray()));
                X509Certificate cert =(X509Certificate) keyentry.getCertificate();
                //--------------------------------------------------------------------------probando cambios---------------------
//                X509Certificate cert=CargarCertificadoPfx();
                //X509Certificate cert =(X509Certificate)ks.getCertificate("sanjose"); // keyentry.getCertificate();
                KeyInfoFactory kin = fac.getKeyInfoFactory();
                List x509Content = new ArrayList();
                x509Content.add(cert.getSubjectX500Principal().getName());
                x509Content.add(cert);
                X509Data xd = kin.newX509Data(x509Content);
                KeyInfo ki = kin.newKeyInfo(Collections.singletonList(xd));
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);
                org.w3c.dom.Document doc = dbf.newDocumentBuilder().parse(inputxml);
                //org.w3c.dom.Document doc = dbf.newDocumentBuilder().parse( d.newInputStream()); //ORIGINAL
                //org.w3c.dom.Document doc = dbf.newDocumentBuilder().parse(  _addtypeinfo.newInputStream());
                Node _nodo = doc.getDocumentElement().getFirstChild().getLastChild().getFirstChild();
                DOMSignContext dsc = new DOMSignContext(keyentry.getPrivateKey(),_nodo);
//              DOMSignContext dsc = new DOMSignContext(ks.getCertificate("sanjose").getPublicKey(),_nodo); //DOMSignContext(keyentry.getPrivateKey(),_nodo);
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
                _envioSunat = new Envio(getStrUsuario(), getStrClave(), fa2);
                if(_envioSunat.Enviardocumento())
                    _rpta= (LeerR(_envioSunat.strRutaResultado));
            } 
        }
        catch(Exception e)
        {System.out.println("Problemas en el envio :"+e.getMessage());}
        return _rpta;
    }
    public boolean LeerR(String x_ruta)  
    {
        boolean _rpta=true;
        try
        {
              String Directorio=x_ruta.substring(0, x_ruta.length()-3);
              String _rutaArchivoDescomprimido="";
              byte[] buffer = new byte[1024];
              File folder = new File(Directorio);
              if(folder.exists())
                  folder.delete();
              folder.mkdir();
              ZipInputStream zis = new ZipInputStream(new FileInputStream(x_ruta));
              ZipEntry ze = zis.getNextEntry();
              File archivo = new File(x_ruta);
              String NombreArchivoXml =archivo.getName().substring(0, archivo.getName().length()-4)+".xml";
              while(ze!=null)
              {
                  String _filename=ze.getName();
                  _rutaArchivoDescomprimido=Directorio+File.separator+NombreArchivoXml;
                  File newfile = new File(_rutaArchivoDescomprimido);
                  System.out.println("file unzip : "+ newfile.getAbsoluteFile());
                  FileOutputStream fos = new FileOutputStream(newfile);
                  int len;
                  while((len=zis.read(buffer))>0)
                  {
                      fos.write(buffer,0,len);
                  }
                  fos.close();
                  ze=zis.getNextEntry();
              }
              zis.closeEntry();
              zis.close();
              System.out.println("unzip Done");
              File xmlfile =new File(_rutaArchivoDescomprimido);
              if(xmlfile.exists())
              {
                  DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
                  DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
                  Document doc = dbuilder.parse(xmlfile);
                  doc.getDocumentElement().normalize();
                  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                  NodeList nlist = doc.getElementsByTagName("cac:DocumentResponse");
                  errReferenceID=  nlist.item(0).getChildNodes().item(1).getChildNodes().item(1).getTextContent();
                  errResponseCode= nlist.item(0).getChildNodes().item(1).getChildNodes().item(3).getTextContent();
                  errDescription= nlist.item(0).getChildNodes().item(1).getChildNodes().item(5).getTextContent();
                  if(Integer.parseInt(errResponseCode)>0)
                  {
                      System.out.println("ResponseCode  :" + errReferenceID);
                      System.out.println("Description :" + errDescription);
                      _rpta=false;
                  }
              }
        }
        catch(Exception e)
        {
            System.out.println("Error leendo nodo: " + e.getMessage());
        }
        return _rpta;
    }   
    public EFactura getEfactura() {
        return _efactura;
    }
    public void setEfactura(EFactura _efactura) {
        this._efactura = _efactura;
    }
    public List<EFacturaDetalle> getLsdetfactura() {
        return _lsdetfactura;
    }
    public void setLsdetfactura(List<EFacturaDetalle> _lsdetfactura) {
        this._lsdetfactura = _lsdetfactura;
    }
    public String getStrUsuario() {
        return strUsuario;
    }
    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }
    public String getStrClave() {
        return strClave;
    }
    public void setStrClave(String strClave) {
        this.strClave = strClave;
    }
    public EEmpresa getEempresa() {
        return _eempresa;
    }
    public void setEempresa(EEmpresa _eempresa) {
        this._eempresa = _eempresa;
        setStrClave(_eempresa.getEmp_cclave());
        setStrUsuario(_eempresa.getEmp_cusuario());
    }
    public ECliente getEcliente() {
        return _ecliente;
    }
    public void setEcliente(ECliente _ecliente) {
        this._ecliente = _ecliente;
    }
    
//    private  X509Certificate  CargarCertificadoPfx()
//    {
//        X509Certificate cert=null;
//        try {
//            FileInputStream stream = new FileInputStream("D:\\CertificadoOriginal\\MPS20160823349277.pfx");
//            KeyStore store =KeyStore.getInstance("PKCS12","SUN");
//            store.load(stream,"estacionsanjose16".toCharArray());
//            Enumeration<String> aliases=store.aliases();
//            while(aliases.hasMoreElements())
//                System.out.println("valor :"+aliases.nextElement());
//             cert =(X509Certificate)store.getCertificate("alias");
//        } catch (Exception e) {System.out.println("Error Leyendo : " + e.getMessage());
//        }
//        
//        return cert;
//    }
    

    
    
    
    
    
    
}
