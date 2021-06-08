package com.example.kontakty;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import android.app.Activity;
import java.util.ArrayList;

public class Kontakty extends Activity{
    ArrayList<ContactsInfo> contactsInfoList;
    ContentResolver contentResolver;
    public Kontakty(ContentResolver contentResolver){
        this.contentResolver = contentResolver;
    }
    @JavascriptInterface

    public String showContacts(){
        getContacts();
        String s = "";
        for(ContactsInfo cs: contactsInfoList){
            s +="<tr><td style='cursor: pointer;'>"+ cs.getDisplayName() + "</td><td>" + cs.getPhoneNumber() + "</td></tr>";
        }
        return s;
    }
    @JavascriptInterface
    public void getContacts(){
        ContentResolver contentResolver = this.contentResolver;
        String contactId = null;
        String displayName = null;
        contactsInfoList = new ArrayList<ContactsInfo>();
        Cursor cursor = this.contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhoneNumber > 0) {

                    ContactsInfo contactsInfo = new ContactsInfo();
                    contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    contactsInfo.setContactId(contactId);
                    contactsInfo.setDisplayName(displayName);

                    Cursor phoneCursor = this.contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{contactId},
                            null);

                    if (phoneCursor.moveToNext()) {
                        String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        contactsInfo.setPhoneNumber(phoneNumber);
                    }

                    phoneCursor.close();

                    contactsInfoList.add(contactsInfo);
                }
            }
        }
        cursor.close();

    }
}
