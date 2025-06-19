package org.emiliano.elbuensaborback.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    // Inyecta el bean configurado en CloudinaryConfig
    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    // Método para subir imagen y devolver la URL pública
    public String subirImagen(MultipartFile archivo) throws IOException {
        // Sube el archivo a Cloudinary
        Map<?, ?> resultado = cloudinary.uploader().upload(archivo.getBytes(), ObjectUtils.emptyMap());
        // Obtiene la URL segura y la retorna
        return resultado.get("secure_url").toString();
    }

}
