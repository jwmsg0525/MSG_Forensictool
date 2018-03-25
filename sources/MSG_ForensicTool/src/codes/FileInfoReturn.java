package codes;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;


public class FileInfoReturn {
	private String Dirpath = null;
	private String Datas = "";
	public FileInfoReturn() {
		// TODO Auto-generated constructor stub
	}
	
	public void setDir(String dirpath) {
		this.Dirpath  = new String(dirpath);
		
	} 
	public boolean fileopen() {
		if(Dirpath==null) {
			return false;
		}
		try {
			Datas+= "DirPath : "+Dirpath+"\n";
			Datas+= "Parse Time (Localtime): "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())+"\n";
			Datas+="Dir/File" + "\t " + "Creation Time"+ "\t\t " + "Modify Time" + "\t\t " + "Access Time" + "\t\t"+ "Size"+ "\t" +"Name"+"\n";
			Datas+="----------------------------------------------------------------------------------------------------------\n";
            File dirs  = new File(Dirpath);
            File [] flist = null;
            if(dirs.isDirectory()) {
            		flist = dirs.listFiles();
            }else {return false;}
            for(File i : flist) {
            	String dirorfile = i.isFile()?"file":"Dir";
            	Path path = Paths.get(i.getAbsolutePath());

            	BasicFileAttributes attributes =
                        Files.readAttributes(path, BasicFileAttributes.class);
            //	System.out.println(dirorfile + "\t" + attributes.creationTime() + "\t" + attributes.lastModifiedTime() + "\t" + attributes.lastAccessTime()+ "\t"+ attributes.size()+ "\t" + i.getName());
            	Datas+=dirorfile + "\t " + attributes.creationTime() + "\t " + attributes.lastModifiedTime() + "\t " + attributes.lastAccessTime()+ "\t"+ attributes.size()+ "\t" + i.getName()+"\n";
            }
            System.out.println(Datas);
            return true;
           
        } catch (Exception ex) {
            return false;
        }
	}
	
	public boolean saving(String savepath) {
		try {
			PrintWriter ot = new PrintWriter(savepath+"/"+Dirpath.replace('/', ')').replace('\\',')')+"-"+new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+".txt");
		    ot.println(Datas);
		    ot.flush();
		    ot.close();
		} catch (Exception e) {
			return false;
		}
				
		return true;
	}
}
