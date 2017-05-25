package com.consultar.controlador;


import com.consultar.entidade.Imagem;
import com.consultar.repositorio.ImagemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;

/**
 * Created by root on 02/05/17.
 */

@Controller
public class FileUploadController {

    private  String url="localhost:8080";
    @Autowired
    private Environment env;
    @Autowired
    ImagemRepositorio imagemRepositorio;


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody

            public Imagem uploadFile(@RequestParam("uploadFile") MultipartFile upload){

        try {
            System.out.print("UploadFile");
        String filename=upload.getOriginalFilename();
        String diretory=env.getProperty("upload.file.path");
        String uploadFilePath= Paths.get("."+ File.separator+diretory,filename).toString();

            final BufferedOutputStream stream=new BufferedOutputStream(
                    new FileOutputStream(
                            new File(uploadFilePath)
                    )
            );
            stream.write(upload.getBytes());
            stream.close();

            Imagem imagem=new Imagem();
            imagem.setUrl(url+filename);
            imagem.setStatus(1);
            imagem.setNome(filename);
            imagem.setLink("");
            return imagemRepositorio.save(imagem);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
      }

}