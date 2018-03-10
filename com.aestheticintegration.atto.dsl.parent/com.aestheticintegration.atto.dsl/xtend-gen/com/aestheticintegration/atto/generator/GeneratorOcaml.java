package com.aestheticintegration.atto.generator;

import com.aestheticintegration.atto.itlDsl.BoolExpression;
import com.aestheticintegration.atto.itlDsl.DefDataType;
import com.aestheticintegration.atto.itlDsl.DefDataValue;
import com.aestheticintegration.atto.itlDsl.DefFunction;
import com.aestheticintegration.atto.itlDsl.DefTest;
import com.aestheticintegration.atto.itlDsl.ExpOrIfStatement;
import com.aestheticintegration.atto.itlDsl.FunctionBody;
import com.aestheticintegration.atto.itlDsl.IfStatement;
import com.aestheticintegration.atto.itlDsl.InputParam;
import com.aestheticintegration.atto.itlDsl.Model;
import com.aestheticintegration.atto.itlDsl.OutputExpression;
import com.aestheticintegration.atto.itlDsl.Statement;
import com.aestheticintegration.atto.util.AttoUtil;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class GeneratorOcaml {
  @Inject
  private AttoUtil attoUtil;
  
  public String className(final Resource res) {
    String name = res.getURI().lastSegment();
    String _substring = name.substring(0, name.indexOf("."));
    return (_substring + ".ml");
  }
  
  public CharSequence compile(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((model != null)) {
        {
          EList<DefDataType> _datatypes = model.getDatatypes();
          for(final DefDataType defDataType : _datatypes) {
            CharSequence _compile = this.compile(defDataType);
            _builder.append(_compile);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          EList<DefDataValue> _datavalues = model.getDatavalues();
          for(final DefDataValue defDataValue : _datavalues) {
            CharSequence _compile_1 = this.compile(defDataValue);
            _builder.append(_compile_1);
            _builder.newLineIfNotEmpty();
          }
        }
        CharSequence _createTypeBuildInExt = this.createTypeBuildInExt(model);
        _builder.append(_createTypeBuildInExt);
        _builder.newLineIfNotEmpty();
        {
          EList<DefFunction> _functions = model.getFunctions();
          for(final DefFunction defFunction : _functions) {
            CharSequence _compile_2 = this.compile(defFunction);
            _builder.append(_compile_2);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("Reflect.Mode.program ()");
        _builder.newLine();
        _builder.append(";;");
        _builder.newLine();
        {
          EList<DefFunction> _functions_1 = model.getFunctions();
          for(final DefFunction defFunction_1 : _functions_1) {
            CharSequence _compileExtra = this.compileExtra(defFunction_1);
            _builder.append(_compileExtra);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compileExtra(final DefFunction defFunction) {
    StringConcatenation _builder = new StringConcatenation();
    String _buildPrepToJson = this.attoUtil.buildPrepToJson(defFunction);
    _builder.append(_buildPrepToJson);
    _builder.newLineIfNotEmpty();
    _builder.append(";;");
    _builder.newLine();
    _builder.append("let func_name = \"");
    String _nameToOcaml = this.attoUtil.nameToOcaml(defFunction.getName());
    _builder.append(_nameToOcaml);
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append(";;");
    _builder.newLine();
    _builder.append("let rs = Decompose.top func_name");
    _builder.newLine();
    _builder.append(";; ");
    _builder.newLine();
    _builder.append("Extract.to_file ~signature:func_name ~filename:\"mex.ml\" ()");
    _builder.newLine();
    _builder.append(";;");
    _builder.newLine();
    _builder.append("System.mod_use \"mex.ml\"");
    _builder.newLine();
    _builder.append(";;");
    _builder.newLine();
    _builder.append("List.iter (fun r -> print_string (Decompose.string_of_region r)) rs");
    _builder.newLine();
    _builder.append(";;");
    _builder.newLine();
    _builder.append("let tcs = List.map Mex.of_region rs");
    _builder.newLine();
    _builder.append(";;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile(final DefDataType defDataType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type ");
    String _lowerCase = defDataType.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(" = {");
    _builder.newLineIfNotEmpty();
    {
      EList<InputParam> _fields = defDataType.getFields();
      for(final InputParam inputParam : _fields) {
        _builder.append("\t");
        String _name = inputParam.getName();
        _builder.append(_name, "\t");
        _builder.append(": ");
        String _lowerCase_1 = this.attoUtil.convertDataTypeToPrimitive(inputParam.getInputDataType()).toLowerCase();
        _builder.append(_lowerCase_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.append(";;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile(final DefDataValue defDataValue) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("let ");
    String _nameToOcaml = this.attoUtil.nameToOcaml(defDataValue.getName());
    _builder.append(_nameToOcaml);
    _builder.append(" = ");
    String _ocamlValue = this.attoUtil.toOcamlValue(defDataValue.getDataTypeInstance());
    _builder.append(_ocamlValue);
    _builder.newLineIfNotEmpty();
    _builder.append(";;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile(final DefFunction defFunction) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("let ");
    String _nameToOcaml = this.attoUtil.nameToOcaml(defFunction.getName());
    _builder.append(_nameToOcaml);
    String _functionParams = this.attoUtil.getFunctionParams(defFunction.getInputParams());
    _builder.append(_functionParams);
    _builder.append(" =");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _compile = this.compile(defFunction.getFunctionBody());
    _builder.append(_compile, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(";;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile(final DefTest test) {
    StringConcatenation _builder = new StringConcatenation();
    String _nameToOcaml = this.attoUtil.nameToOcaml(test.getDefFunc().getName());
    _builder.append(_nameToOcaml);
    _builder.append(" ");
    String _allDataTypeValueAsString = this.attoUtil.getAllDataTypeValueAsString(test.getDataTypeValues());
    _builder.append(_allDataTypeValueAsString);
    _builder.newLineIfNotEmpty();
    _builder.append(";;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile(final EList<InputParam> inputParams) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = inputParams.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index : _doubleDotLessThan) {
        {
          if (((index).intValue() == 0)) {
            String _name = inputParams.get((index).intValue()).getName();
            _builder.append(_name);
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append(", ");
            String _name_1 = inputParams.get((index).intValue()).getName();
            _builder.append(_name_1);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compile(final FunctionBody functionBody) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Statement> _statement = functionBody.getStatement();
      for(final Statement statement : _statement) {
        {
          IfStatement _ifStatement = statement.getIfStatement();
          boolean _tripleNotEquals = (_ifStatement != null);
          if (_tripleNotEquals) {
            CharSequence _compile = this.compile(statement.getIfStatement());
            _builder.append(_compile);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          OutputExpression _outputExpression = statement.getOutputExpression();
          boolean _tripleNotEquals_1 = (_outputExpression != null);
          if (_tripleNotEquals_1) {
            String _outputExpressionValueAsString = this.attoUtil.getOutputExpressionValueAsString(statement.getOutputExpression());
            _builder.append(_outputExpressionValueAsString);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence compile(final IfStatement ifStatement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if ");
    CharSequence _compile2 = this.compile2(ifStatement.getInputBoolExpression());
    _builder.append(_compile2);
    _builder.newLineIfNotEmpty();
    _builder.append("then ");
    CharSequence _compile = this.compile(ifStatement.getThenExpOrIfStatement());
    _builder.append(_compile);
    _builder.newLineIfNotEmpty();
    {
      ExpOrIfStatement _elseExpOrIfStatement = ifStatement.getElseExpOrIfStatement();
      boolean _tripleNotEquals = (_elseExpOrIfStatement != null);
      if (_tripleNotEquals) {
        _builder.append("else ");
        CharSequence _compile_1 = this.compile(ifStatement.getElseExpOrIfStatement());
        _builder.append(_compile_1);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence compile(final ExpOrIfStatement expOrIfStatement) {
    StringConcatenation _builder = new StringConcatenation();
    {
      OutputExpression _outputExpression = expOrIfStatement.getOutputExpression();
      boolean _tripleNotEquals = (_outputExpression != null);
      if (_tripleNotEquals) {
        String _outputExpressionValueAsString = this.attoUtil.getOutputExpressionValueAsString(expOrIfStatement.getOutputExpression());
        _builder.append(_outputExpressionValueAsString);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      IfStatement _ifStatement = expOrIfStatement.getIfStatement();
      boolean _tripleNotEquals_1 = (_ifStatement != null);
      if (_tripleNotEquals_1) {
        Object _compile = this.compile(expOrIfStatement.getIfStatement());
        _builder.append(_compile);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence compile2(final EList<BoolExpression> boolExpressionList) {
    StringConcatenation _builder = new StringConcatenation();
    String _boolExpressionListAsString = this.attoUtil.getBoolExpressionListAsString(boolExpressionList);
    _builder.append(_boolExpressionListAsString);
    _builder.append("\t\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence createTypeBuildInExt(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type build_in_ext = ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EXCEPTION of string");
    _builder.newLine();
    _builder.append("|\tNO_EXN_BOOL of bool");
    _builder.newLine();
    _builder.append("|\tNO_EXN_INTEGER of int");
    _builder.newLine();
    _builder.append("|\tNO_EXN_FLOAT of float");
    _builder.newLine();
    _builder.append("|\tNO_EXN_STRING of string");
    _builder.newLine();
    {
      EList<DefDataType> _datatypes = model.getDatatypes();
      for(final DefDataType defDataType : _datatypes) {
        _builder.append("|\tNO_EXN_");
        String _upperCase = defDataType.getName().toUpperCase();
        _builder.append(_upperCase);
        _builder.append(" of ");
        String _lowerCase = defDataType.getName().toLowerCase();
        _builder.append(_lowerCase);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(";;");
    _builder.newLine();
    return _builder;
  }
}
