type build_in_ext = 
	EXCEPTION of string
|	NO_EXN_BOOL of bool
|	NO_EXN_INTEGER of int
|	NO_EXN_FLOAT of float
|	NO_EXN_STRING of string
;;
let simpleProg_myTest1 (param1:int) (param2:bool) =
	if param1 = 0		
	then NO_EXN_INTEGER 88
	else if param2 = true		
	then NO_EXN_INTEGER 44
	else NO_EXN_INTEGER 33
;;
let simpleProg_myTest1a (cityTemp:int) =
	if cityTemp = 0		
	then EXCEPTION "Wrong input for this function"
	else NO_EXN_INTEGER 33
;;
let simpleProg_myTest1b (param1:int) =
	if param1 = 0		
	then EXCEPTION "Wrong input for this function"
	else if param1 = 1		
	then EXCEPTION "Do not use this input"
	else NO_EXN_INTEGER 33
;;
Reflect.Mode.program ()
;;
let prep_simpleProg_myTest1  (param1:int) (param2:bool) = [ ("param1", `Int param1);  ("param2", `Bool param2)]
;;
let func_name = "simpleProg_myTest1"
;;
let rs = Decompose.top func_name
;; 
Extract.to_file ~signature:func_name ~filename:"mex.ml" ()
;;
System.mod_use "mex.ml"
;;
List.iter (fun r -> print_string (Decompose.string_of_region r)) rs
;;
let tcs = List.map Mex.of_region rs
;;
let prep_simpleProg_myTest1a  (cityTemp:int) = [ ("cityTemp", `Int cityTemp)]
;;
let func_name = "simpleProg_myTest1a"
;;
let rs = Decompose.top func_name
;; 
Extract.to_file ~signature:func_name ~filename:"mex.ml" ()
;;
System.mod_use "mex.ml"
;;
List.iter (fun r -> print_string (Decompose.string_of_region r)) rs
;;
let tcs = List.map Mex.of_region rs
;;
let prep_simpleProg_myTest1b  (param1:int) = [ ("param1", `Int param1)]
;;
let func_name = "simpleProg_myTest1b"
;;
let rs = Decompose.top func_name
;; 
Extract.to_file ~signature:func_name ~filename:"mex.ml" ()
;;
System.mod_use "mex.ml"
;;
List.iter (fun r -> print_string (Decompose.string_of_region r)) rs
;;
let tcs = List.map Mex.of_region rs
;;
