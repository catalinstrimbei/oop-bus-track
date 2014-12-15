/**
 * Best practice: modularization with plain modules
 * Run context: 
 * * front-client:	web browser
 * * front-client:	phantom-js
 * * back-server:	node-js	 
 */

// declare/import provider module [data module]
var dataModule = (function(){
	// dsl constructor
	var projectTemplate = function(){
		return {
			projectID: 	function(id){ this.projectID = id; return this;},
			name:		function(name){ this.name = name;  return this;},
			startDate:	function(date){ this.startDate = date;  return this;},
			toString:	function(){
				return this.projectID + ", " 
					+ this.name + ", " 
					+ this.startDate;
			}
		}
	};
	// asociative vector?
	var projectStore = [];
	return {
		getProject: function(ID){
			for(i=0; i<projectStore.length; i++)
				if((projectStore[i]) && projectStore[i].projectID == ID)
					return projectStore[i];
			projectStore[i] = new projectTemplate().projectID(ID);
			return projectStore[i];
		},
		putProject: function(project){
			for(i=0; i<projectStore.length; i++)
				if((projectStore[i]) && projectStore[i].projectID == ID){
					projectStore[i] = project;
					return;
				}
			projectStore[i] = project;			
		},
		deleteProject: function(){},
		getAllProjects: function(){
			return projectStore;
		}
	}
})();

// declare custom module [controller module] - inject provider
var dataConsumer = function(dataModule){
	var project = dataModule.getProject(1);
	project.name("Project 1");
	project.startDate(new Date());
	
	project = dataModule.getProject(2);
	project.name("Project 2");
	project.startDate(new Date());
	
	var projects = dataModule.getAllProjects();
	
	return {
		listAllProjects: function(){
			console.log("List of all projects: " + projects.length);
			for(i=0; i<projects.length; i++)
				if (projects[i])
					console.log(projects[i].toString());
		}
	}
};

// run custom module - call provider module
dataConsumer(dataModule).listAllProjects();


//-------------------------------------------------------------//
try{phantom.exit();}catch(e){}