package com.database.system.wsconsumedatabase.firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.database.system.wsconsumedatabase.dto.UsuariosDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Component
public class UsuarioFBClient {

	
	public static final String COL_NAME="users";
    
    public String guardarUsuarioFB(UsuariosDTO usuario) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(usuario.getIdUsuario().toString()).set(usuario);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public UsuariosDTO obtenerUsuarioFB(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        UsuariosDTO user = null;
        if(document.exists()) {
        	user = document.toObject(UsuariosDTO.class);
            return user;
        }else {
            return null;
        }
    }

    public String actualizarUsuarioFB(UsuariosDTO usuario) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(usuario.getIdUsuario().toString()).set(usuario);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String eliminarUsiarioFB(String idUsuario) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(idUsuario).delete();
        return "Document with Patient ID "+idUsuario+" has been deleted";
    }
    
    public List<UsuariosDTO> obtenerTodosFB() throws InterruptedException, ExecutionException{
    	List<UsuariosDTO> users = new ArrayList<UsuariosDTO>();
    	Firestore dbFirestore = FirestoreClient.getFirestore();
    	ApiFuture<QuerySnapshot> apiFuture =  dbFirestore.collection(COL_NAME).get();
    	List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
    	documents.forEach(document->{
    		users.add(document.toObject(UsuariosDTO.class));
    	});
    	return users;
    }
}
