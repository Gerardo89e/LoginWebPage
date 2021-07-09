package manager;

public class Manager {
		
		protected int id;
	    protected String name;
	    protected String country;
	    protected String email;
	    protected int request;
	    protected String pass;
	    
	 
	    public Manager () {
	    }
	 
	    public Manager(int id) {
	        this.id = id;
	    }
	 /*
	    public User(int id, String title, String author, float price) {
	        this(title, author, price);
	        this.id = id;
	    }*/
	    public Manager(String name, String email,String country) {
	        this.name=name;
	        this.country=country;
	        this.email=email;
	    }
	    // public User(String pass, String email) {
	    public Manager(String pass, String email) {
			super();
			this.pass = pass;
			//this.utype=utype;
			this.email = email;
		}
	    public Manager(int id, String name, String email,String country,int request) {
	        this(name, email, country,request);
	        
	        this.id = id;
	    }
	    public Manager(String name, String email,String country,int request) {
			super();
			this.name=name;
			this.country = country;
			this.request=request;
			this.email = email;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getRequest() {
			return request;
		}

		public void setRequest(int request) {
			this.request = request;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}
	/*
		public String getUtype() {
			return utype;
		}

		public void setUtype(String utype) {
			this.utype = utype;
		}
	*/

		
	    
	     /*
	    public User(String title, String author, float price) {
	        this.title = title;
	        this.author = author;
	        this.price = price;
	        
	    }*/
	}