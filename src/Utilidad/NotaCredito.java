
package Utilidad;

import AccessoDato.ECliente;
import AccessoDato.EEmpresa;
import AccessoDato.EFactura;
import AccessoDato.EFacturaDetalle;
import AccessoDato.ERelacionadoDocumentoDetalle;
import AccessoDato.ERelacionadoDocumento;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.BillingReferenceType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.CreditNoteLineType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.CustomerPartyType;
//import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.CustomerPartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.DocumentReferenceType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.ItemType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.MonetaryTotalType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PartyLegalEntityType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PriceType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.PricingReferenceType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.ResponseType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.SignatureType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.SupplierPartyType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxCategoryType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxSchemeType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxSubtotalType;
import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxTotalType;
//import oasisNamesSpecificationUblSchemaXsdCommonAggregateComponents2.TaxTotalType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.CreditedQuantityType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.LineExtensionAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.PayableAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.PriceAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonBasicComponents2.TaxAmountType;
import oasisNamesSpecificationUblSchemaXsdCommonExtensionComponents2.ExtensionContentType;
import oasisNamesSpecificationUblSchemaXsdCommonExtensionComponents2.UBLExtensionsType;
import oasisNamesSpecificationUblSchemaXsdCreditNote2.CreditNoteDocument;
import oasisNamesSpecificationUblSchemaXsdCreditNote2.CreditNoteType;
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

public class NotaCredito {

    private EEmpresa _eempresa;
    private ECliente _ecliente;
    CreditNoteDocument _crednotadocumento;
    CreditNoteType _creditnote;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Formato _fmd;
    private EFactura _efactura=null;
    private List<EFacturaDetalle>  _lsdetfactura=null;
    ExtensionContentType _nodoFirma;
    private List<ERelacionadoDocumentoDetalle> _lsrelaciondoc;
    private ERelacionadoDocumento _erelaciondoc;
    String rutaXml="";
    String rutazip="";
    File fa =null;
    File fa2=null;
    public NotaCredito() {
         _fmd = new Formato();
    }
//    public boolean GenerarNoteCredito()
//    {
//        try {
//             _crednotadocumento =CreditNoteDocument.Factory.newInstance();
//             _creditnote=_crednotadocumento.addNewCreditNote();
//             XmlCursor _cursor= _creditnote.newCursor();
//             _cursor.toNextToken();
//             _cursor.insertNamespace(null, "urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2");
//             _cursor.insertNamespace("cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
//             _cursor.insertNamespace("cac", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
//             _cursor.insertNamespace("ext","urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
//             /////////////////////////////////////////////////////////TAG EXTRAS ////////////////////////////////
//             _cursor.insertNamespace("ccts","urn:oasis:names:specification:ubl:schema:xsd:CoreComponentParameters-2");
//             _cursor.insertNamespace("qdt","urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
//             _cursor.insertNamespace("stat","urn:oasis:names:specification:ubl:schema:xsd:DocumentStatusCode-1.0");
//             _cursor.insertNamespace("udt","urn:un:unece:uncefact:data:draft:UnqualifiedDataTypesSchemaModule:2");
//             //////////////////////////////////////////////////////////FIN DE TAG EXTRAS///////////////////////////
//             _cursor.insertNamespace("ds","http://www.w3.org/2000/09/xmldsig#");
//             _cursor.insertNamespace("sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
//             _creditnote.documentProperties().setEncoding("ISO-8859-1");
//             _creditnote.documentProperties().setStandalone(false);
//             _creditnote.addNewIssueDate().setStringValue(dateFormat.format(_efactura.getFac_dfechaemision()));
//             UBLExtensionsType _ubltype= _creditnote.addNewUBLExtensions();
//             _nodoFirma =_ubltype.addNewUBLExtension().addNewExtensionContent();
//             _ubltype.addNewUBLExtension().addNewExtensionContent();
//             _creditnote.addNewUBLVersionID().setStringValue("2.0");/////////////////////////////////////////////////VERSION DEL ESQUEMA UBL -NO MODIFICAR ESTATICO
//             _creditnote.addNewCustomizationID().setStringValue("1.0");/////////////////////////////////////////////VERSION DE LA ESTRUCTURA DEL COCUMENTO  -NO MODIFICAR ESTATICO
//             _creditnote.addNewID().setStringValue("dasdasd");/////////////////////////////////////////////////////SERIE Y NUMERO-VARIABLE
//             _creditnote.addNewDocumentCurrencyCode().setStringValue("PEN");
//        } catch (Exception e) {
//        }
//        return true;
//    }
    private void AddUBLExtensions()
    {
        try
        {
            UBLExtensionsType _ubltype= _creditnote.addNewUBLExtensions(); //--------------------------Tag principales
             _nodoFirma =_ubltype.addNewUBLExtension().addNewExtensionContent();//----------Tag para firma digital
             _ubltype.addNewUBLExtension().addNewExtensionContent(); //---------------------Tag para Additionalinformation             
        }
        catch(Exception e)
        {System.out.println("Creacion Tag principales UBLExtensions :"+e.getMessage());}

    }
    private void AddDiscrepancyResponce()
    {
        try {
            ResponseType _responsetype= _creditnote.addNewDiscrepancyResponse();
            _responsetype.addNewReferenceID().setStringValue(_erelaciondoc.getRel_facserienumero());
            _responsetype.addNewResponseCode().setStringValue(_erelaciondoc.getMtv_ccodigo());
            _responsetype.addNewDescription().setStringValue(_erelaciondoc.getRel_cdescripcion());
        } catch (Exception e) { System.out.println("Error AddDiscrepancyResponce:"+e.getMessage()); }
    }
    private void AddBillingReference()
    {
        try {
                BillingReferenceType _billreferencetype= _creditnote.addNewBillingReference();
                DocumentReferenceType _documentreferencetype=_billreferencetype.addNewInvoiceDocumentReference();
                _documentreferencetype.addNewID().setStringValue(_erelaciondoc.getRel_cserie()+"-"+_erelaciondoc.getRel_cnumero());
                _documentreferencetype.addNewDocumentTypeCode().setStringValue(_erelaciondoc.getDoc_ccodigo());
        } catch (Exception e) { System.out.println("Error AddBillingReference:"+e.getMessage());}
    }
    private void AddDespatchDocumentReference()
    {
        try {
                    DocumentReferenceType _documentreferencetype=_creditnote.addNewDespatchDocumentReference();
                    _documentreferencetype.addNewID().setStringValue("");
                    _documentreferencetype.addNewDocumentTypeCode().setStringValue("");
                    
        } catch (Exception e) { System.out.println("Error AddDespatchDocumentReference:"+e.getMessage());
        }
    }
    private void AddAdditionalDocumentReference()
    {
        try {
                DocumentReferenceType _documentreferencetype=_creditnote.addNewAdditionalDocumentReference();
                _documentreferencetype.addNewID().setStringValue("");
                _documentreferencetype.addNewDocumentTypeCode().setStringValue("");
        } catch (Exception e) {System.out.println("Error AddAdditionalDocumentReference:"+e.getMessage());    }
    }
    private void AddSignature()
    {
        try {
                SignatureType _signaturetype=_creditnote.addNewSignature();
                _signaturetype.addNewID().setStringValue("IDSignKG");
                PartyType _partytype=_signaturetype.addNewSignatoryParty();
                _partytype.addNewPartyIdentification().addNewID().setStringValue(_eempresa.getEmp_cruc());
                _partytype.addNewPartyName().addNewName().setStringValue(_eempresa.getEmp_cnombre());
                AttachmentType _digitalsignaturetype=_signaturetype.addNewDigitalSignatureAttachment();
                _digitalsignaturetype.addNewExternalReference().addNewURI().setStringValue("signatureKG");
                
        } catch (Exception e) { System.out.println("Error AddSignature:"+e.getMessage()); }
    }
    private void AddAccountingSupplierParty()
    {
        try {
            SupplierPartyType _supplierpartytype=_creditnote.addNewAccountingSupplierParty();
            _supplierpartytype.addNewCustomerAssignedAccountID().setStringValue(_eempresa.getEmp_cruc());
            _supplierpartytype.addNewAdditionalAccountID().setStringValue(_eempresa.getDoi_ccodigo());
            PartyType _partytype=_supplierpartytype.addNewParty();
            _partytype.addNewPartyName().addNewName().setStringValue(_eempresa.getEmp_cnombre());
            AddressType _addressstype=_partytype.addNewPostalAddress();
            _addressstype.addNewID().setStringValue(_eempresa.getCodigoubigeo());
            _addressstype.addNewStreetName().setStringValue(_eempresa.getDireccionsucursal());
            _addressstype.addNewCitySubdivisionName().setStringValue(_eempresa.getDistrito());
            _addressstype.addNewCityName().setStringValue(_eempresa.getDepartamento());
            _addressstype.addNewCountrySubentity().setStringValue(_eempresa.getProvincia());
            _addressstype.addNewDistrict().setStringValue(_eempresa.getDistrito());
            _addressstype.addNewCountry().addNewIdentificationCode().setStringValue("PE");
            PartyLegalEntityType _partylegalentitytype=_partytype.addNewPartyLegalEntity();
            _partylegalentitytype.addNewRegistrationName().setStringValue(_eempresa.getEmp_cnombre());
        } catch (Exception e) { System.out.println("Error AddAccountingSupplierParty:"+e.getMessage());       }
    }
    private void AddAccountingCustomerParty()
    {
        try {
                CustomerPartyType _customerparty=_creditnote.addNewAccountingCustomerParty();
                _customerparty.addNewCustomerAssignedAccountID().setStringValue(_ecliente.getCli_cnumerodoc());
                _customerparty.addNewAdditionalAccountID().setStringValue(_ecliente.getCoi_ccodigo());
                PartyType _partytypecustomer=_customerparty.addNewParty();
                _partytypecustomer.addNewPartyLegalEntity().addNewRegistrationName().setStringValue(_ecliente.getCli_crazon());
        } catch (Exception e)
        { System.out.println("Error AddAccountingCustomerParty:"+e.getMessage());       }
    }
    private void AddTaxTotal()
    {
        try {
            TaxTotalType _taxtotaltype=_creditnote.addNewTaxTotal();//----------------------------------------IGV
            TaxAmountType _taxamounttype= _taxtotaltype.addNewTaxAmount();
            _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN );
            _taxamounttype.setStringValue(""+_erelaciondoc.getRel_figv());
            TaxSubtotalType _taxsubtotaltype=_taxtotaltype.addNewTaxSubtotal();
            TaxAmountType _taxamounttypeigv=_taxsubtotaltype.addNewTaxAmount();
            _taxamounttypeigv.setCurrencyID(CurrencyCodeContentType.PEN);
            _taxamounttypeigv.setStringValue(""+_erelaciondoc.getRel_figv());
            TaxSchemeType _taxschemetype=_taxsubtotaltype.addNewTaxCategory().addNewTaxScheme();
            _taxschemetype.addNewID().setStringValue("1000");
            _taxschemetype.addNewName().setStringValue("IGV");
            _taxschemetype.addNewTaxTypeCode().setStringValue("VAT");
            TaxTotalType _taxtotaltypeisc =_creditnote.addNewTaxTotal();//-------------------------------------ISC
            TaxAmountType _taxamounttypeisc =_taxtotaltypeisc.addNewTaxAmount();
            _taxamounttypeisc.setCurrencyID(CurrencyCodeContentType.PEN);
            _taxamounttypeisc.setStringValue(""+_fmd.Farmat2DosDecimales(_erelaciondoc.getRel_ftotalisc()));
            TaxSubtotalType _taxsubtotaltypeisc=_taxtotaltypeisc.addNewTaxSubtotal();
            _taxamounttypeisc=_taxsubtotaltypeisc.addNewTaxAmount();
            _taxamounttypeisc.setCurrencyID(CurrencyCodeContentType.PEN);
            _taxamounttypeisc.setStringValue(""+_fmd.Farmat2DosDecimales(_erelaciondoc.getRel_ftotalisc()));
            _taxschemetype=_taxsubtotaltypeisc.addNewTaxCategory().addNewTaxScheme();
            _taxschemetype.addNewID().setStringValue("2000");
            _taxschemetype.addNewName().setStringValue("ISC");
            _taxschemetype.addNewTaxTypeCode().setStringValue("EXC");
            TaxTotalType _taxtotaltypeotr=_creditnote.addNewTaxTotal();//---------------------------------------OTR
            TaxAmountType _taxamountypeotr=_taxtotaltypeotr.addNewTaxAmount();
            _taxamountypeotr.setCurrencyID(CurrencyCodeContentType.PEN);
            _taxamountypeotr.setStringValue(""+_fmd.Farmat2DosDecimales(_erelaciondoc.getRel_ftotalotrostributos()));
            TaxSubtotalType _taxsubtotaltypeotr =_taxtotaltypeotr.addNewTaxSubtotal();
            _taxamountypeotr=_taxsubtotaltypeotr.addNewTaxAmount();
            _taxamountypeotr.setCurrencyID(CurrencyCodeContentType.PEN);
            _taxamountypeotr.setStringValue(""+_fmd.Farmat2DosDecimales(_erelaciondoc.getRel_ftotalotrostributos()));
            _taxschemetype=_taxsubtotaltypeotr.addNewTaxCategory().addNewTaxScheme();
            _taxschemetype.addNewID().setStringValue("9999");
            _taxschemetype.addNewName().setStringValue("OTROS TRIBUTOS");
            _taxschemetype.addNewTaxTypeCode().setStringValue("OTH");
        } catch (Exception e) {System.out.println("Error AddTaxTotal:"+e.getMessage());       }
    }
    private void AddLegalMonetaryTotal()
    {
        try {
            MonetaryTotalType _legalmonetarytotal= _creditnote.addNewLegalMonetaryTotal();            
            PayableAmountType _payableamount=_legalmonetarytotal.addNewPayableAmount();
            _payableamount.setCurrencyID(CurrencyCodeContentType.PEN);//-------------------------------------------------Moneda total a pagar
            _payableamount.setStringValue(""+(_fmd.Farmat2DosDecimales(_erelaciondoc.getRel_ftotal())));
        } catch (Exception e) { System.out.println("Error AddLegalMonetaryTotal:"+e.getMessage());        }
    }
    private void AddCrediNoteLine(int i)
    {
        try {
            CreditNoteLineType _line=_creditnote.addNewCreditNoteLine();
            _line.addNewID().setStringValue("+i");
            CreditedQuantityType _creditquantitytype= _line.addNewCreditedQuantity();
            _creditquantitytype.setUnitCode(UnitCodeContentType.CS);
            _creditquantitytype.setStringValue(""+_lsrelaciondoc.get(i).getRde_ccantidad());
            LineExtensionAmountType _linextensiontype= _line.addNewLineExtensionAmount();
            _linextensiontype.setCurrencyID(CurrencyCodeContentType.PEN);
            _linextensiontype.setStringValue(""+_fmd.Farmat2DosDecimales(_lsrelaciondoc.get(i).getRde_fvalorsubtotal()));
            PricingReferenceType _pricingreferencetype=_line.addNewPricingReference();
            PriceType _pricetype=_pricingreferencetype.addNewAlternativeConditionPrice();
            PriceAmountType _priceamounttype=_pricetype.addNewPriceAmount();
            _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
            _priceamounttype.setStringValue(""+_fmd.Farmat2DosDecimales(_lsrelaciondoc.get(i).getRde_fvalorventa()));
            _pricetype.addNewPriceType().setStringValue("01");
            
            TaxTotalType _taxtotal =_line.addNewTaxTotal();
            TaxAmountType _taxamounttype = _taxtotal.addNewTaxAmount();
            _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
            _taxamounttype.setStringValue(""+_fmd.Farmat2DosDecimales((_lsrelaciondoc.get(i).getRde_fvaloritemigv())));
            TaxSubtotalType _taxsubtotaltype =_taxtotal.addNewTaxSubtotal();
            _taxamounttype=_taxsubtotaltype.addNewTaxAmount();
            _taxamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
            _taxamounttype.setStringValue(""+_fmd.Farmat2DosDecimales((_lsrelaciondoc.get(i).getRde_fvaloritemigv())));
            TaxCategoryType _taxcategorytype=_taxsubtotaltype.addNewTaxCategory();
            _taxcategorytype.addNewTaxExemptionReasonCode().setStringValue(""+_lsrelaciondoc.get(i).getRde_ctipoafectacion());
            TaxSchemeType _taxschemetype=_taxcategorytype.addNewTaxScheme();
            _taxschemetype.addNewID().setStringValue("1000");
            _taxschemetype.addNewName().setStringValue("IGV");
            _taxschemetype.addNewTaxTypeCode().setStringValue("VAT");
            ItemType _itemtype= _line.addNewItem();
            _itemtype.addNewDescription().setStringValue(""+_lsdetfactura.get(i).getArt_cdescripcion());
            _itemtype.addNewSellersItemIdentification().addNewID().setStringValue(""+_lsrelaciondoc.get(i).getArt_ncodigo());
            PriceType _pricetypeitem=_line.addNewPrice();
            _priceamounttype= _pricetypeitem.addNewPriceAmount();
            _priceamounttype.setCurrencyID(CurrencyCodeContentType.PEN);
            _priceamounttype.setStringValue(""+_fmd.Farmat2DosDecimales(_lsrelaciondoc.get(i).getRde_fvalorunitario()));
        } catch (Exception e) { System.out.println("Error AddCrediNoteLine:"+e.getMessage());         }
    }
    private void addTagHeader()
    {
        try
        {
            XmlCursor _cursor=   _creditnote.newCursor();
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
        catch(Exception e){System.out.println("Error addTagHeader:"+e.getMessage()); }
    }
    private void addNamesFile()
    {
        try
        {
            rutaXml= "d:\\Facturacion\\"+_eempresa.getEmp_cruc()+"-"+_erelaciondoc.getDoc_ccodigo()+"-"+_erelaciondoc.getRel_cserie()+"-"+_erelaciondoc.getRel_cnumero()+".xml";
            rutazip="d:\\Facturacion\\"+_eempresa.getEmp_cruc()+"-"+_erelaciondoc.getDoc_ccodigo()+"-"+_erelaciondoc.getRel_cserie()+"-"+_erelaciondoc.getRel_cnumero()+".zip";
            fa= new File(rutaXml);
        }
        catch(Exception e)
        {System.out.println("Error al definir files:"+e.getMessage());}
    }
    public boolean  FillXml()
    {
        boolean _estado=true;
        try
        {
            addNamesFile();
            _crednotadocumento= CreditNoteDocument.Factory.newInstance();             
            _creditnote = _crednotadocumento.addNewCreditNote();
            addTagHeader();
            _crednotadocumento.documentProperties().setEncoding("ISO-8859-1");
            _crednotadocumento.documentProperties().setStandalone(false);
            _creditnote.addNewIssueDate().setStringValue(dateFormat.format(_erelaciondoc.getRel_dfechaemision()));//-----------Fecha de emision del comproante 
            AddUBLExtensions();
            _creditnote.addNewUBLVersionID().setStringValue("2.0");///-----------------------------------------------------Version del Esquema UBL
            _creditnote.addNewCustomizationID().setStringValue("1.0");//---------------------------------------------------Version del documento
            _creditnote.addNewID().setStringValue(_erelaciondoc.getRel_cserie()+"-"+_erelaciondoc.getRel_cnumero());//-------------Serie y numero de Documento
            _creditnote.addNewDocumentCurrencyCode().setStringValue(_erelaciondoc.getRel_cmoneda());
            AddDiscrepancyResponce();
            AddBillingReference();
//            AddDespatchDocumentReference();
//            AddAdditionalDocumentReference();
            AddSignature();
            AddAccountingSupplierParty();
            AddAccountingCustomerParty();
            AddTaxTotal();
            AddLegalMonetaryTotal();
            for (int i=0;i<=_lsrelaciondoc.size()-1;i++)
            {AddCrediNoteLine(i);}
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
    InputStream inputxml;
    private String strUsuario;
    private String strClave;
    private Envio _envioSunat;
    public void GenerarFirma()
    {
        try
        {
                XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
                Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, null),Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),null,null);
                SignedInfo _si =fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec)null),fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));
                KeyStore ks =KeyStore.getInstance("JKS");
                File fff = new File("d:\\keystore.jks");
                fff.isFile();
                ks.load(new FileInputStream("d:\\keystore.jks"),"password".toCharArray());
                KeyStore.PrivateKeyEntry keyentry= (KeyStore.PrivateKeyEntry) ks.getEntry("test01", new KeyStore.PasswordProtection("password".toCharArray()));
                X509Certificate cert =(X509Certificate) keyentry.getCertificate();
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

    public String getStrClave() {
        return strClave;
    }

    public void setStrClave(String strClave) {
        this.strClave = strClave;
    }

    public String getStrUsuario() {
        return strUsuario;
    }

    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }
    public String  errReferenceID;
    public String  errResponseCode;
    public String   errDescription;
    AdditionalInformationType _addtypeinfo;
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
             _addpayamounttypeinfo.setStringValue(""+_erelaciondoc.getRel_fsubtotal());
             _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1002");//////////////////////////////////CASO 1002
             _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
             _addpayamounttypeinfo.setStringValue(""+_erelaciondoc.getRel_ftotalinafecto());
             _typemonetaryaddinfo=_addtypeinfo.addNewAdditionalMonetaryTotal();
             _typemonetaryaddinfo.addNewID().setStringValue("1003");//////////////////////////////////CASO 1003
             _addpayamounttypeinfo=_typemonetaryaddinfo.addNewPayableAmount();
             _addpayamounttypeinfo.setCurrencyID(CurrencyCodeContentType.PEN);
             _addpayamounttypeinfo.setStringValue(""+_erelaciondoc.getRel_ftotalexonerado());
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
             Document docnotecredi=null;
             Document docinfoadd=null;
             db= dbf.newDocumentBuilder();
             docnotecredi =db.parse(_crednotadocumento.newInputStream());
             docinfoadd=db.parse(x_additionalinformationdocument.newInputStream());
             Node _nodeAdd = docnotecredi.importNode(docinfoadd.getElementsByTagName("sac:AdditionalInformation").item(0), true);
             Node ndListdoc =docnotecredi.getElementsByTagName("ext:ExtensionContent").item(0);
             ndListdoc.appendChild(_nodeAdd);
             TransformerFactory tFactory = TransformerFactory.newInstance();
             Transformer transformer = tFactory.newTransformer();
             transformer.setOutputProperty(OutputKeys.INDENT, "yes");            
             DOMSource source = new DOMSource(docnotecredi);             
             StreamResult result = new StreamResult(new StringWriter());
             transformer.transform(source, result); 
             ByteArrayOutputStream _salidaxml= new ByteArrayOutputStream();//----------------------------------Salida InputStream
             Result outtarge= new StreamResult(_salidaxml);
             TransformerFactory.newInstance().newTransformer().transform(source, outtarge);
             inputxml=new ByteArrayInputStream(_salidaxml.toByteArray());
        }
        catch(Exception e)
        {System.out.println("Error Merge de documentos:"+e.getMessage());}
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

    public List<ERelacionadoDocumentoDetalle> getLsrelaciondoc() {
        return _lsrelaciondoc;
    }

    public void setLsrelaciondoc(List<ERelacionadoDocumentoDetalle> _lsrelaciondoc) {
        this._lsrelaciondoc = _lsrelaciondoc;
    }

    public ERelacionadoDocumento getErelaciondoc() {
        return _erelaciondoc;
    }

    public void setErelaciondoc(ERelacionadoDocumento _erelaciondoc) {
        this._erelaciondoc = _erelaciondoc;
    }
}

