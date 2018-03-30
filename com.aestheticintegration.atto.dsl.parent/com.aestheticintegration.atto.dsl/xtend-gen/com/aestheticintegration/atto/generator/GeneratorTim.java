package com.aestheticintegration.atto.generator;

import com.aestheticintegration.atto.itlDsl.DataTypeInstance;
import com.aestheticintegration.atto.itlDsl.DataTypeValue;
import com.aestheticintegration.atto.itlDsl.DefDataType;
import com.aestheticintegration.atto.itlDsl.DefDataValue;
import com.aestheticintegration.atto.itlDsl.DefFunction;
import com.aestheticintegration.atto.itlDsl.DefImport;
import com.aestheticintegration.atto.itlDsl.DefTest;
import com.aestheticintegration.atto.itlDsl.Model;
import com.aestheticintegration.atto.itlDsl.Primary;
import com.aestheticintegration.atto.util.AttoUtil;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class GeneratorTim {
  @Inject
  private AttoUtil attoUtil;
  
  public String className(final Resource res) {
    String name = res.getURI().lastSegment();
    String _substring = name.substring(0, name.indexOf("."));
    return (_substring + ".tim");
  }
  
  public CharSequence compile(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((model != null)) {
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _compile = this.compile(model.getImports());
        _builder.append(_compile, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _compile2 = this.compile2(model.getDatatypes());
        _builder.append(_compile2, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _compile3 = this.compile3(model.getDatavalues());
        _builder.append(_compile3, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _compile4 = this.compile4(model.getFunctions());
        _builder.append(_compile4, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _compile5 = this.compile5(model.getTests());
        _builder.append(_compile5, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence compile(final EList<DefImport> imports) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"imports\": [");
    _builder.newLine();
    {
      int _size = imports.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index : _doubleDotLessThan) {
        _builder.append("\"");
        String _name = imports.get((index).intValue()).getName();
        _builder.append(_name);
        _builder.append("\" ");
        {
          int _size_1 = imports.size();
          int _minus = (_size_1 - 1);
          boolean _tripleNotEquals = ((index).intValue() != _minus);
          if (_tripleNotEquals) {
            _builder.append(" , ");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("],");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile2(final EList<DefDataType> datatypes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"datatypes\": [");
    _builder.newLine();
    {
      int _size = datatypes.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index : _doubleDotLessThan) {
        _builder.append("\t");
        _builder.append("{ \"name\": \"");
        String _name = datatypes.get((index).intValue()).getName();
        _builder.append(_name, "\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t  ");
        _builder.append("\"fields\": [");
        _builder.newLine();
        {
          int _size_1 = datatypes.get((index).intValue()).getFields().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
          for(final Integer index2 : _doubleDotLessThan_1) {
            _builder.append("{ \"name\": \"");
            String _name_1 = datatypes.get((index).intValue()).getFields().get((index2).intValue()).getName();
            _builder.append(_name_1);
            _builder.append("\",");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("\"type\": \"");
            String _convertDataTypeToString = this.attoUtil.convertDataTypeToString(datatypes.get((index).intValue()).getFields().get((index2).intValue()).getInputDataType());
            _builder.append(_convertDataTypeToString, "  ");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            {
              int _size_2 = datatypes.get((index).intValue()).getFields().size();
              int _minus = (_size_2 - 1);
              boolean _tripleNotEquals = ((index2).intValue() != _minus);
              if (_tripleNotEquals) {
                _builder.append(" , ");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("]");
        _builder.newLine();
        _builder.append("}");
        {
          int _size_3 = datatypes.size();
          int _minus_1 = (_size_3 - 1);
          boolean _tripleNotEquals_1 = ((index).intValue() != _minus_1);
          if (_tripleNotEquals_1) {
            _builder.append(" , ");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("],");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile3(final EList<DefDataValue> datavalues) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"datavalues\": [");
    _builder.newLine();
    {
      int _size = datavalues.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index : _doubleDotLessThan) {
        CharSequence _compile3a = this.compile3a(datavalues.get((index).intValue()));
        _builder.append(_compile3a);
        _builder.newLineIfNotEmpty();
        {
          int _size_1 = datavalues.size();
          int _minus = (_size_1 - 1);
          boolean _tripleNotEquals = ((index).intValue() != _minus);
          if (_tripleNotEquals) {
            _builder.append(" , ");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("],");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile3a(final DefDataValue datavalue) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ \"name\": \"");
    String _name = datavalue.getName();
    _builder.append(_name);
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"datatype\": \"");
    String _name_1 = datavalue.getDataTypeInstance().getDefDataType().getName();
    _builder.append(_name_1, "  ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"fields\": [");
    _builder.newLine();
    {
      int _size = datavalue.getDataTypeInstance().getLiterals().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index2 : _doubleDotLessThan) {
        String _literalValueAsString = this.attoUtil.getLiteralValueAsString(datavalue.getDataTypeInstance().getLiterals().get((index2).intValue()));
        _builder.append(_literalValueAsString);
        {
          int _size_1 = datavalue.getDataTypeInstance().getLiterals().size();
          int _minus = (_size_1 - 1);
          boolean _tripleNotEquals = ((index2).intValue() != _minus);
          if (_tripleNotEquals) {
            _builder.append(" , ");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("}\t");
    return _builder;
  }
  
  public CharSequence compile4(final EList<DefFunction> functions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"functions\": [");
    _builder.newLine();
    {
      int _size = functions.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index : _doubleDotLessThan) {
        _builder.append("{ \"name\": \"");
        String _name = functions.get((index).intValue()).getName();
        _builder.append(_name);
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"mlName\":\"");
        String _nameToOcaml = this.attoUtil.nameToOcaml(functions.get((index).intValue()).getName());
        _builder.append(_nameToOcaml, "  ");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("\"inputParams\": [");
        _builder.newLine();
        {
          int _size_1 = functions.get((index).intValue()).getInputParams().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
          for(final Integer index2 : _doubleDotLessThan_1) {
            _builder.append("\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\"name\":\"");
            String _name_1 = functions.get((index).intValue()).getInputParams().get((index2).intValue()).getName();
            _builder.append(_name_1, "\t");
            _builder.append("\",");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\"type\":\"");
            String _convertDataTypeToString = this.attoUtil.convertDataTypeToString(functions.get((index).intValue()).getInputParams().get((index2).intValue()).getInputDataType());
            _builder.append(_convertDataTypeToString, "\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            {
              int _size_2 = functions.get((index).intValue()).getInputParams().size();
              int _minus = (_size_2 - 1);
              boolean _tripleNotEquals = ((index2).intValue() != _minus);
              if (_tripleNotEquals) {
                _builder.append(" , ");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("\t\t  ");
        _builder.append("\"returnType\": \"");
        String _convertDataTypeToString_1 = this.attoUtil.convertDataTypeToString(functions.get((index).intValue()).getOutputDataType());
        _builder.append(_convertDataTypeToString_1, "\t\t  ");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t  ");
        _builder.append("\"testCases\" : [");
        _builder.newLine();
        _builder.append("\t\t  \t");
        _builder.append("{ \"constraints\": \"\",");
        _builder.newLine();
        _builder.append("\t\t  \t  ");
        _builder.append("\"input\": null,");
        _builder.newLine();
        _builder.append("\t\t  \t  ");
        _builder.append("\"output_expect\": null,");
        _builder.newLine();
        _builder.append("\t\t  \t  ");
        _builder.append("\"output_actual\": null");
        _builder.newLine();
        _builder.append("\t\t  \t ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t   ");
        _builder.append("]");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        {
          int _size_3 = functions.size();
          int _minus_1 = (_size_3 - 1);
          boolean _tripleNotEquals_1 = ((index).intValue() != _minus_1);
          if (_tripleNotEquals_1) {
            _builder.append(" , ");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("],");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compile5(final EList<DefTest> tests) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"tests\": [");
    _builder.newLine();
    {
      int _size = tests.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer index : _doubleDotLessThan) {
        _builder.append("{ \"name\": \"");
        String _name = tests.get((index).intValue()).getName();
        _builder.append(_name);
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"function\": \"");
        String _name_1 = tests.get((index).intValue()).getDefFunc().getName();
        _builder.append(_name_1, "  ");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"input\": [");
        _builder.newLine();
        {
          int _size_1 = tests.get((index).intValue()).getDataTypeValues().size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
          for(final Integer index2 : _doubleDotLessThan_1) {
            _builder.append("\t\t\t");
            DataTypeValue dataTypeValue = tests.get((index).intValue()).getDataTypeValues().get((index2).intValue());
            _builder.newLineIfNotEmpty();
            {
              Primary _primary = dataTypeValue.getPrimary();
              boolean _tripleNotEquals = (_primary != null);
              if (_tripleNotEquals) {
                _builder.append("\t\t\t");
                String _primaryValueAsString = this.attoUtil.getPrimaryValueAsString(dataTypeValue.getPrimary());
                _builder.append(_primaryValueAsString, "\t\t\t");
                {
                  int _size_2 = tests.get((index).intValue()).getDataTypeValues().size();
                  int _minus = (_size_2 - 1);
                  boolean _tripleNotEquals_1 = ((index2).intValue() != _minus);
                  if (_tripleNotEquals_1) {
                    _builder.append(" , ");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
            {
              DataTypeInstance _dataTypeInstance = dataTypeValue.getDataTypeInstance();
              boolean _tripleNotEquals_2 = (_dataTypeInstance != null);
              if (_tripleNotEquals_2) {
                _builder.append("\t\t\t");
                _builder.append("{");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\"datatype\": \"");
                String _name_2 = dataTypeValue.getDataTypeInstance().getDefDataType().getName();
                _builder.append(_name_2, "\t\t\t");
                _builder.append("\",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\"fields\":[");
                _builder.newLine();
                {
                  int _size_3 = dataTypeValue.getDataTypeInstance().getLiterals().size();
                  ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_3, true);
                  for(final Integer index3 : _doubleDotLessThan_2) {
                    _builder.append("\t\t\t");
                    String _literalValueAsString = this.attoUtil.getLiteralValueAsString(dataTypeValue.getDataTypeInstance().getLiterals().get((index3).intValue()));
                    _builder.append(_literalValueAsString, "\t\t\t");
                    {
                      int _size_4 = dataTypeValue.getDataTypeInstance().getLiterals().size();
                      int _minus_1 = (_size_4 - 1);
                      boolean _tripleNotEquals_3 = ((index3).intValue() != _minus_1);
                      if (_tripleNotEquals_3) {
                        _builder.append(" , ");
                      }
                    }
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t\t");
                _builder.append("]");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("}");
                {
                  int _size_5 = tests.get((index).intValue()).getDataTypeValues().size();
                  int _minus_2 = (_size_5 - 1);
                  boolean _tripleNotEquals_4 = ((index2).intValue() != _minus_2);
                  if (_tripleNotEquals_4) {
                    _builder.append(" , ");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
            {
              DefDataValue _defDataValue = dataTypeValue.getDefDataValue();
              boolean _tripleNotEquals_5 = (_defDataValue != null);
              if (_tripleNotEquals_5) {
                _builder.append("\t\t\t");
                _builder.append("{");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("\"datavalue\": \"");
                String _name_3 = dataTypeValue.getDefDataValue().getName();
                _builder.append(_name_3, "\t\t\t");
                _builder.append("\"");
                {
                  int _size_6 = tests.get((index).intValue()).getDataTypeValues().size();
                  int _minus_3 = (_size_6 - 1);
                  boolean _tripleNotEquals_6 = ((index2).intValue() != _minus_3);
                  if (_tripleNotEquals_6) {
                    _builder.append(" , ");
                  }
                }
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.append(" ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  \t   ");
        _builder.append("\"output_expect\" : ");
        String _outputExpressionAsString = this.attoUtil.getOutputExpressionAsString(tests.get((index).intValue()).getOutputExpression());
        _builder.append(_outputExpressionAsString, "  \t   ");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t   ");
        _builder.append("\"output_actual\": null");
        _builder.newLine();
        _builder.append("}");
        {
          int _size_7 = tests.size();
          int _minus_4 = (_size_7 - 1);
          boolean _tripleNotEquals_7 = ((index).intValue() != _minus_4);
          if (_tripleNotEquals_7) {
            _builder.append(" , ");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
}
