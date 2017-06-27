package edu.chap7.generics;

public class DVDInfo {
		String title;
		String genere;
		String leadActor;
		public  DVDInfo(String t,String g,String l){
			title=t;
			genere=g;
			leadActor=l;
			
		}
		public String toString(){
			return title + " " + genere + " " +leadActor + "\n";
		}
		public int compareTo(DVDInfo d)
		{
			return title.compareTo(d.getTitle());
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGenere() {
			return genere;
		}
		public void setGenere(String genere) {
			this.genere = genere;
		}
		public String getLeadActor() {
			return leadActor;
		}
		public void setLeadActor(String leadActor) {
			this.leadActor = leadActor;
		}
		

}
