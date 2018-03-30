package com.aestheticintegration.atto.util;

import com.aestheticintegration.atto.itlDsl.BoolExpression;
import com.aestheticintegration.atto.itlDsl.DataType;
import com.aestheticintegration.atto.itlDsl.DataTypeInstance;
import com.aestheticintegration.atto.itlDsl.DataTypeValue;
import com.aestheticintegration.atto.itlDsl.DefDataType;
import com.aestheticintegration.atto.itlDsl.DefDataValue;
import com.aestheticintegration.atto.itlDsl.DefFunction;
import com.aestheticintegration.atto.itlDsl.DefTest;
import com.aestheticintegration.atto.itlDsl.ExpOrIfStatement;
import com.aestheticintegration.atto.itlDsl.IfStatement;
import com.aestheticintegration.atto.itlDsl.InputParam;
import com.aestheticintegration.atto.itlDsl.Literal;
import com.aestheticintegration.atto.itlDsl.Null;
import com.aestheticintegration.atto.itlDsl.OutputExpression;
import com.aestheticintegration.atto.itlDsl.Primary;
import com.aestheticintegration.atto.itlDsl.Primitives;
import com.aestheticintegration.atto.itlDsl.Statement;
import com.aestheticintegration.atto.itlDsl.impl.BooleanImpl;
import com.aestheticintegration.atto.itlDsl.impl.DataTypeInstanceImpl;
import com.aestheticintegration.atto.itlDsl.impl.DefDataValueImpl;
import com.aestheticintegration.atto.itlDsl.impl.DefFunctionImpl;
import com.aestheticintegration.atto.itlDsl.impl.ExceptionImpl;
import com.aestheticintegration.atto.itlDsl.impl.FloatImpl;
import com.aestheticintegration.atto.itlDsl.impl.IfStatementImpl;
import com.aestheticintegration.atto.itlDsl.impl.IntegerImpl;
import com.aestheticintegration.atto.itlDsl.impl.ModelImpl;
import com.aestheticintegration.atto.itlDsl.impl.NullImpl;
import com.aestheticintegration.atto.itlDsl.impl.StringImpl;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class AttoUtil {
  public String convertDataTypeToString(final DataType dataType) {
    String str = null;
    String _boolean = dataType.getBoolean();
    boolean _tripleNotEquals = (_boolean != null);
    if (_tripleNotEquals) {
      str = "boolean";
    } else {
      String _booleanObj = dataType.getBooleanObj();
      boolean _tripleNotEquals_1 = (_booleanObj != null);
      if (_tripleNotEquals_1) {
        str = "Boolean";
      } else {
        String _short = dataType.getShort();
        boolean _tripleNotEquals_2 = (_short != null);
        if (_tripleNotEquals_2) {
          str = "short";
        } else {
          String _shortObj = dataType.getShortObj();
          boolean _tripleNotEquals_3 = (_shortObj != null);
          if (_tripleNotEquals_3) {
            str = "Short";
          } else {
            String _int = dataType.getInt();
            boolean _tripleNotEquals_4 = (_int != null);
            if (_tripleNotEquals_4) {
              str = "int";
            } else {
              String _intObj = dataType.getIntObj();
              boolean _tripleNotEquals_5 = (_intObj != null);
              if (_tripleNotEquals_5) {
                str = "Integer";
              } else {
                String _long = dataType.getLong();
                boolean _tripleNotEquals_6 = (_long != null);
                if (_tripleNotEquals_6) {
                  str = "long";
                } else {
                  String _longObj = dataType.getLongObj();
                  boolean _tripleNotEquals_7 = (_longObj != null);
                  if (_tripleNotEquals_7) {
                    str = "Long";
                  } else {
                    String _float = dataType.getFloat();
                    boolean _tripleNotEquals_8 = (_float != null);
                    if (_tripleNotEquals_8) {
                      str = "float";
                    } else {
                      String _floatObj = dataType.getFloatObj();
                      boolean _tripleNotEquals_9 = (_floatObj != null);
                      if (_tripleNotEquals_9) {
                        str = "Float";
                      } else {
                        String _double = dataType.getDouble();
                        boolean _tripleNotEquals_10 = (_double != null);
                        if (_tripleNotEquals_10) {
                          str = "double";
                        } else {
                          String _doubleObj = dataType.getDoubleObj();
                          boolean _tripleNotEquals_11 = (_doubleObj != null);
                          if (_tripleNotEquals_11) {
                            str = "Double";
                          } else {
                            String _string = dataType.getString();
                            boolean _tripleNotEquals_12 = (_string != null);
                            if (_tripleNotEquals_12) {
                              str = "String";
                            } else {
                              DefDataType _defDataType = dataType.getDefDataType();
                              boolean _tripleNotEquals_13 = (_defDataType != null);
                              if (_tripleNotEquals_13) {
                                str = dataType.getDefDataType().getName();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return str;
  }
  
  public String convertDataTypeToPrimitive(final DataType dataType) {
    String dataTypeOut = null;
    String _boolean = dataType.getBoolean();
    boolean _tripleNotEquals = (_boolean != null);
    if (_tripleNotEquals) {
      dataTypeOut = Primitives.BOOL.getLiteral();
    } else {
      String _booleanObj = dataType.getBooleanObj();
      boolean _tripleNotEquals_1 = (_booleanObj != null);
      if (_tripleNotEquals_1) {
        dataTypeOut = Primitives.BOOLOPT.getLiteral();
      } else {
        if ((((dataType.getShort() != null) || (dataType.getInt() != null)) || (dataType.getLong() != null))) {
          dataTypeOut = Primitives.INT.getLiteral();
        } else {
          if ((((dataType.getShortObj() != null) || (dataType.getIntObj() != null)) || (dataType.getLongObj() != null))) {
            dataTypeOut = Primitives.INTOPT.getLiteral();
          } else {
            if (((dataType.getFloat() != null) || (dataType.getDouble() != null))) {
              dataTypeOut = Primitives.FLOAT.getLiteral();
            } else {
              if (((dataType.getFloatObj() != null) || (dataType.getDoubleObj() != null))) {
                dataTypeOut = Primitives.FLOATOPT.getLiteral();
              } else {
                String _string = dataType.getString();
                boolean _tripleNotEquals_2 = (_string != null);
                if (_tripleNotEquals_2) {
                  dataTypeOut = Primitives.STRINGOPT.getLiteral();
                } else {
                  DefDataType _defDataType = dataType.getDefDataType();
                  boolean _tripleNotEquals_3 = (_defDataType != null);
                  if (_tripleNotEquals_3) {
                    dataTypeOut = dataType.getDefDataType().getName();
                  }
                }
              }
            }
          }
        }
      }
    }
    return dataTypeOut;
  }
  
  public String convertDataTypeToOption(final DataType dataType) {
    String dataTypeOut = null;
    String _boolean = dataType.getBoolean();
    boolean _tripleNotEquals = (_boolean != null);
    if (_tripleNotEquals) {
      dataTypeOut = Primitives.BOOL.getLiteral();
    } else {
      String _booleanObj = dataType.getBooleanObj();
      boolean _tripleNotEquals_1 = (_booleanObj != null);
      if (_tripleNotEquals_1) {
        String _literal = Primitives.BOOL.getLiteral();
        String _plus = (_literal + " objOpt");
        dataTypeOut = _plus;
      } else {
        if ((((dataType.getShort() != null) || (dataType.getInt() != null)) || (dataType.getLong() != null))) {
          dataTypeOut = Primitives.INT.getLiteral();
        } else {
          if ((((dataType.getShortObj() != null) || (dataType.getIntObj() != null)) || (dataType.getLongObj() != null))) {
            String _literal_1 = Primitives.INT.getLiteral();
            String _plus_1 = (_literal_1 + " objOpt");
            dataTypeOut = _plus_1;
          } else {
            if (((dataType.getFloat() != null) || (dataType.getDouble() != null))) {
              dataTypeOut = Primitives.FLOAT.getLiteral();
            } else {
              if (((dataType.getFloatObj() != null) || (dataType.getDoubleObj() != null))) {
                String _literal_2 = Primitives.FLOAT.getLiteral();
                String _plus_2 = (_literal_2 + " objOpt");
                dataTypeOut = _plus_2;
              } else {
                String _string = dataType.getString();
                boolean _tripleNotEquals_2 = (_string != null);
                if (_tripleNotEquals_2) {
                  String _literal_3 = Primitives.STRING.getLiteral();
                  String _plus_3 = (_literal_3 + " objOpt");
                  dataTypeOut = _plus_3;
                } else {
                  DefDataType _defDataType = dataType.getDefDataType();
                  boolean _tripleNotEquals_3 = (_defDataType != null);
                  if (_tripleNotEquals_3) {
                    dataTypeOut = dataType.getDefDataType().getName();
                  }
                }
              }
            }
          }
        }
      }
    }
    return dataTypeOut;
  }
  
  public String convertLiteralToPrimitive(final Literal literal) {
    String _variable = literal.getVariable();
    boolean _tripleNotEquals = (_variable != null);
    if (_tripleNotEquals) {
      String[] idVars = literal.getVariable().split("\\.");
      DefFunction defFunction = this.getDefFunction(literal);
      InputParam inputParam = null;
      EList<InputParam> _inputParams = defFunction.getInputParams();
      for (final InputParam inputParam0 : _inputParams) {
        String _name = inputParam0.getName();
        Object _get = idVars[0];
        boolean _equals = Objects.equal(_name, _get);
        if (_equals) {
          inputParam = inputParam0;
        }
      }
      if ((inputParam == null)) {
        return "";
      }
      String dataType = inputParam.getInputDataType().getDefDataType().getName();
      EList<DefDataType> _allDefDataTypes = this.getAllDefDataTypes(defFunction);
      for (final DefDataType dataType2 : _allDefDataTypes) {
        String _name_1 = dataType2.getName();
        boolean _equals_1 = Objects.equal(_name_1, dataType);
        if (_equals_1) {
          EList<InputParam> _fields = dataType2.getFields();
          for (final InputParam inputParam3 : _fields) {
            String _name_2 = inputParam3.getName();
            Object _get_1 = idVars[1];
            boolean _equals_2 = Objects.equal(_name_2, _get_1);
            if (_equals_2) {
              DataType dataType4 = inputParam3.getInputDataType();
              return this.convertDataTypeToPrimitive(dataType4);
            }
          }
        }
      }
      return "";
    } else {
      Primary _primary = literal.getPrimary();
      boolean _tripleNotEquals_1 = (_primary != null);
      if (_tripleNotEquals_1) {
        return this.convertPrimaryToPrimitive(literal.getPrimary());
      }
    }
    return null;
  }
  
  public String convertPrimaryToPrimitive(final Primary primary) {
    String primaryType = null;
    if ((primary instanceof BooleanImpl)) {
      primaryType = Primitives.BOOL.getLiteral();
    } else {
      if ((primary instanceof IntegerImpl)) {
        primaryType = Primitives.INT.getLiteral();
      } else {
        if ((primary instanceof FloatImpl)) {
          primaryType = Primitives.FLOAT.getLiteral();
        } else {
          if ((primary instanceof StringImpl)) {
            primaryType = Primitives.STRINGOPT.getLiteral();
          } else {
            if ((primary instanceof NullImpl)) {
              primaryType = Primitives.NULL.getLiteral();
            }
          }
        }
      }
    }
    return primaryType;
  }
  
  public EList<DefDataType> getAllDefDataTypes(final EObject eObject) {
    EObject eContainer = eObject.eContainer();
    while (((eContainer != null) && (!(eContainer instanceof ModelImpl)))) {
      eContainer = eContainer.eContainer();
    }
    return ((ModelImpl) eContainer).getDatatypes();
  }
  
  public EList<DefDataValue> getAllDefDataValues(final EObject eObject) {
    EObject eContainer = eObject.eContainer();
    while (((eContainer != null) && (!(eContainer instanceof ModelImpl)))) {
      eContainer = eContainer.eContainer();
    }
    return ((ModelImpl) eContainer).getDatavalues();
  }
  
  public EList<DefFunction> getAllDefFunctions(final EObject eObject) {
    EObject eContainer = eObject.eContainer();
    while (((eContainer != null) && (!(eContainer instanceof ModelImpl)))) {
      eContainer = eContainer.eContainer();
    }
    return ((ModelImpl) eContainer).getFunctions();
  }
  
  public DefFunction getDefFunction(final EObject eObject) {
    EObject eContainer = eObject.eContainer();
    while (((eContainer != null) && (!(eContainer instanceof DefFunctionImpl)))) {
      eContainer = eContainer.eContainer();
    }
    return ((DefFunctionImpl) eContainer);
  }
  
  public EList<DefTest> getAllDefTests(final EObject eObject) {
    EObject eContainer = eObject.eContainer();
    while (((eContainer != null) && (!(eContainer instanceof ModelImpl)))) {
      eContainer = eContainer.eContainer();
    }
    return ((ModelImpl) eContainer).getTests();
  }
  
  public String getLiteralValueAsString(final Literal literal) {
    String _variable = literal.getVariable();
    boolean _tripleNotEquals = (_variable != null);
    if (_tripleNotEquals) {
      return literal.getVariable();
    } else {
      Primary _primary = literal.getPrimary();
      boolean _tripleNotEquals_1 = (_primary != null);
      if (_tripleNotEquals_1) {
        return this.getPrimaryValueAsString(literal.getPrimary());
      }
    }
    return null;
  }
  
  public String getPrimaryValueAsString(final Primary primary) {
    String primaryValue = "";
    if ((primary instanceof BooleanImpl)) {
      primaryValue = ((BooleanImpl) primary).getValueBoolean().toString();
    } else {
      if ((primary instanceof IntegerImpl)) {
        primaryValue = ((IntegerImpl) primary).getValueInteger().toString();
      } else {
        if ((primary instanceof FloatImpl)) {
          primaryValue = ((FloatImpl) primary).getValueFloat().toString();
        } else {
          if ((primary instanceof StringImpl)) {
            String _valueString = ((StringImpl) primary).getValueString();
            String _plus = ("\"" + _valueString);
            String _plus_1 = (_plus + "\"");
            primaryValue = _plus_1;
          } else {
            if ((primary instanceof NullImpl)) {
              primaryValue = Primitives.NULL.getLiteral();
            }
          }
        }
      }
    }
    return primaryValue;
  }
  
  public String getOutputExpressionValueAsString(final OutputExpression outputExpression) {
    String outputExpressionValue = "";
    if ((outputExpression instanceof ExceptionImpl)) {
      String _valueException = ((ExceptionImpl) outputExpression).getValueException();
      String _plus = (("Exception " + "\"") + _valueException);
      String _plus_1 = (_plus + "\"");
      outputExpressionValue = _plus_1;
    } else {
      if ((outputExpression instanceof NullImpl)) {
        outputExpressionValue = "Nothing";
      } else {
        if ((outputExpression instanceof StringImpl)) {
          String _valueString = ((StringImpl) outputExpression).getValueString();
          String _plus_2 = ("\"" + _valueString);
          String _plus_3 = (_plus_2 + "\"");
          outputExpressionValue = _plus_3;
        } else {
          String some = "Something ";
          if ((outputExpression instanceof BooleanImpl)) {
            String _string = ((BooleanImpl) outputExpression).getValueBoolean().toString();
            String _plus_4 = (some + _string);
            outputExpressionValue = _plus_4;
          } else {
            if ((outputExpression instanceof IntegerImpl)) {
              String _string_1 = ((IntegerImpl) outputExpression).getValueInteger().toString();
              String _plus_5 = (some + _string_1);
              outputExpressionValue = _plus_5;
            } else {
              if ((outputExpression instanceof FloatImpl)) {
                String _string_2 = ((FloatImpl) outputExpression).getValueFloat().toString();
                String _plus_6 = (some + _string_2);
                outputExpressionValue = _plus_6;
              } else {
                if ((outputExpression instanceof DataTypeInstance)) {
                  String _ocamlValue = this.toOcamlValue(((DataTypeInstance) outputExpression).getDataTypeInstance());
                  String _plus_7 = (some + _ocamlValue);
                  outputExpressionValue = _plus_7;
                } else {
                  if ((outputExpression instanceof DefDataValue)) {
                    String _name = ((DefDataValue) outputExpression).getValueDataValue().getName();
                    String _plus_8 = (some + _name);
                    outputExpressionValue = _plus_8;
                  }
                }
              }
            }
          }
        }
      }
    }
    return outputExpressionValue;
  }
  
  public String convertOutputExpressionToPrimitive(final OutputExpression outputExpression) {
    String dataTypeOut = null;
    if ((outputExpression instanceof BooleanImpl)) {
      dataTypeOut = Primitives.BOOL.getLiteral();
    } else {
      if ((outputExpression instanceof IntegerImpl)) {
        dataTypeOut = Primitives.INT.getLiteral();
      } else {
        if ((outputExpression instanceof FloatImpl)) {
          dataTypeOut = Primitives.FLOAT.getLiteral();
        } else {
          if ((outputExpression instanceof StringImpl)) {
            dataTypeOut = Primitives.STRINGOPT.getLiteral();
          } else {
            if ((outputExpression instanceof NullImpl)) {
              dataTypeOut = Primitives.NULL.getLiteral();
            } else {
              if ((outputExpression instanceof DataTypeInstanceImpl)) {
                dataTypeOut = ((DataTypeInstanceImpl) outputExpression).getDataTypeInstance().getDefDataType().getName();
              } else {
                if ((outputExpression instanceof DefDataValueImpl)) {
                  EList<DefDataValue> datavalues = this.getAllDefDataValues(outputExpression);
                  if (((datavalues != null) && (datavalues.size() != 0))) {
                    for (final DefDataValue defDataValue : datavalues) {
                      String _name = defDataValue.getName();
                      String _name_1 = ((DefDataValueImpl) outputExpression).getValueDataValue().getName();
                      boolean _equals = Objects.equal(_name, _name_1);
                      if (_equals) {
                        dataTypeOut = defDataValue.getDataTypeInstance().getDefDataType().getName();
                      }
                    }
                  }
                } else {
                  if ((outputExpression instanceof ExceptionImpl)) {
                    dataTypeOut = Primitives.EXCEPTION.getLiteral();
                  }
                }
              }
            }
          }
        }
      }
    }
    return dataTypeOut;
  }
  
  public String toOcamlType(final DataTypeInstance dataTypeInstance) {
    String str = "{";
    EList<InputParam> dataTypeFields = dataTypeInstance.getDefDataType().getFields();
    String comma = "";
    for (int index = 0; (index < dataTypeFields.size()); index++) {
      {
        String fieldName = dataTypeFields.get(index).getName();
        String fieldValue = this.convertDataTypeToOption(dataTypeFields.get(index).getInputDataType());
        str = ((((str + comma) + fieldName) + "=") + fieldValue);
        comma = "; ";
      }
    }
    String _str = str;
    str = (_str + "}");
    return str;
  }
  
  public String toOcamlValue(final DataTypeInstance dataTypeInstance) {
    String str = "{";
    EList<InputParam> dataTypeFields = dataTypeInstance.getDefDataType().getFields();
    String comma = "";
    for (int index = 0; (index < dataTypeFields.size()); index++) {
      {
        String fieldName = dataTypeFields.get(index).getName();
        String fieldValue = this.getLiteralValueAsString(dataTypeInstance.getLiterals().get(index));
        str = ((((str + comma) + fieldName) + "=") + fieldValue);
        comma = "; ";
      }
    }
    String _str = str;
    str = (_str + "}");
    return str;
  }
  
  public String getAllDataTypeValueAsString(final EList<DataTypeValue> dataTypeValues) {
    String str = "";
    String comma = "";
    for (int index = 0; (index < dataTypeValues.size()); index++) {
      {
        DataTypeValue dataTypeValue = dataTypeValues.get(index);
        Primary _primary = dataTypeValue.getPrimary();
        boolean _tripleNotEquals = (_primary != null);
        if (_tripleNotEquals) {
          String _primaryValueAsString = this.getPrimaryValueAsString(dataTypeValue.getPrimary());
          String _plus = ((str + comma) + _primaryValueAsString);
          str = _plus;
        } else {
          DataTypeInstance _dataTypeInstance = dataTypeValue.getDataTypeInstance();
          boolean _tripleNotEquals_1 = (_dataTypeInstance != null);
          if (_tripleNotEquals_1) {
            String comma2 = "";
            str = (str + "{");
            for (int index2 = 0; (index2 < dataTypeValue.getDataTypeInstance().getLiterals().size()); index2++) {
              {
                String _name = dataTypeValue.getDataTypeInstance().getDefDataType().getFields().get(index2).getName();
                String _plus_1 = ((str + comma2) + _name);
                String _plus_2 = (_plus_1 + "=");
                str = _plus_2;
                String _literalValueAsString = this.getLiteralValueAsString(dataTypeValue.getDataTypeInstance().getLiterals().get(index2));
                String _plus_3 = (str + _literalValueAsString);
                str = _plus_3;
                comma2 = "; ";
              }
            }
            str = (str + "}");
          } else {
            DefDataValue _defDataValue = dataTypeValue.getDefDataValue();
            boolean _tripleNotEquals_2 = (_defDataValue != null);
            if (_tripleNotEquals_2) {
              String _lowerCase = dataTypeValue.getDefDataValue().getName().toLowerCase();
              String _plus_1 = ((str + comma) + _lowerCase);
              str = _plus_1;
            }
          }
        }
        comma = ", ";
      }
    }
    return str;
  }
  
  public String getDataTypeValueAsString(final DataTypeValue dataTypeValue) {
    String str = "";
    Primary _primary = dataTypeValue.getPrimary();
    boolean _tripleNotEquals = (_primary != null);
    if (_tripleNotEquals) {
      str = this.getPrimaryValueAsString(dataTypeValue.getPrimary());
    } else {
      DataTypeInstance _dataTypeInstance = dataTypeValue.getDataTypeInstance();
      boolean _tripleNotEquals_1 = (_dataTypeInstance != null);
      if (_tripleNotEquals_1) {
        String comma2 = "";
        str = (str + "{");
        for (int index2 = 0; (index2 < dataTypeValue.getDataTypeInstance().getLiterals().size()); index2++) {
          {
            String _name = dataTypeValue.getDataTypeInstance().getDefDataType().getFields().get(index2).getName();
            String _plus = ((str + comma2) + _name);
            String _plus_1 = (_plus + "=");
            str = _plus_1;
            String _literalValueAsString = this.getLiteralValueAsString(dataTypeValue.getDataTypeInstance().getLiterals().get(index2));
            String _plus_2 = (str + _literalValueAsString);
            str = _plus_2;
            comma2 = "; ";
          }
        }
        str = (str + "}");
      } else {
        DefDataValue _defDataValue = dataTypeValue.getDefDataValue();
        boolean _tripleNotEquals_2 = (_defDataValue != null);
        if (_tripleNotEquals_2) {
          str = dataTypeValue.getDefDataValue().getName().toLowerCase();
        }
      }
    }
    return str;
  }
  
  public String getOutputExpressionAsString(final OutputExpression outputExpression) {
    String str = "";
    if ((outputExpression instanceof BooleanImpl)) {
      str = ((BooleanImpl) outputExpression).getValueBoolean().toString();
    } else {
      if ((outputExpression instanceof IntegerImpl)) {
        str = ((IntegerImpl) outputExpression).getValueInteger().toString();
      } else {
        if ((outputExpression instanceof FloatImpl)) {
          str = ((FloatImpl) outputExpression).getValueFloat().toString();
        } else {
          if ((outputExpression instanceof StringImpl)) {
            String _valueString = ((StringImpl) outputExpression).getValueString();
            String _plus = ("\"" + _valueString);
            String _plus_1 = (_plus + "\"");
            str = _plus_1;
          } else {
            if ((outputExpression instanceof DataTypeInstance)) {
              String comma2 = "";
              str = (str + "{");
              for (int index2 = 0; (index2 < ((DataTypeInstance)outputExpression).getDataTypeInstance().getLiterals().size()); index2++) {
                {
                  String _name = ((DataTypeInstance)outputExpression).getDataTypeInstance().getDefDataType().getFields().get(index2).getName();
                  String _plus_2 = ((str + comma2) + _name);
                  String _plus_3 = (_plus_2 + "=");
                  str = _plus_3;
                  String _literalValueAsString = this.getLiteralValueAsString(((DataTypeInstance)outputExpression).getDataTypeInstance().getLiterals().get(index2));
                  String _plus_4 = (str + _literalValueAsString);
                  str = _plus_4;
                  comma2 = "; ";
                }
              }
              str = (str + "}");
            } else {
              if ((outputExpression instanceof DefDataValue)) {
                DataTypeInstance dataTypeInstance = ((DefDataValue) outputExpression).getValueDataValue().getDataTypeInstance();
                String _name = ((DefDataValue)outputExpression).getValueDataValue().getName();
                String _plus_2 = ("{ \"name\": \"" + _name);
                String _plus_3 = (_plus_2 + "\", ");
                String _plus_4 = (_plus_3 + 
                  "\"datatype\": \"");
                String _name_1 = dataTypeInstance.getDefDataType().getName();
                String _plus_5 = (_plus_4 + _name_1);
                String _plus_6 = (_plus_5 + "\", ");
                String _plus_7 = (_plus_6 + 
                  "\"fields\": [");
                str = _plus_7;
                for (int index2 = 0; (index2 < dataTypeInstance.getLiterals().size()); index2++) {
                  {
                    String _literalValueAsString = this.getLiteralValueAsString(dataTypeInstance.getLiterals().get(index2));
                    String _plus_8 = (str + _literalValueAsString);
                    str = _plus_8;
                    int _size = dataTypeInstance.getLiterals().size();
                    int _minus = (_size - 1);
                    boolean _tripleNotEquals = (index2 != _minus);
                    if (_tripleNotEquals) {
                      str = (str + " , ");
                    }
                  }
                }
                str = ((str + "]") + "}");
              } else {
                if ((outputExpression instanceof ExceptionImpl)) {
                  String _valueException = ((ExceptionImpl) outputExpression).getValueException();
                  String _plus_8 = (("\"Exception " + "\\\"") + _valueException);
                  String _plus_9 = (_plus_8 + "\\\"\"");
                  str = _plus_9;
                }
              }
            }
          }
        }
      }
    }
    return str;
  }
  
  public boolean hasFunctionException(final DefFunction defFunciton) {
    EList<Statement> _statement = defFunciton.getFunctionBody().getStatement();
    for (final Statement statement : _statement) {
      IfStatement _ifStatement = statement.getIfStatement();
      boolean _tripleNotEquals = (_ifStatement != null);
      if (_tripleNotEquals) {
        boolean _hasIfStatementException = this.hasIfStatementException(statement.getIfStatement());
        if (_hasIfStatementException) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasIfStatementException(final IfStatement ifStatement) {
    boolean _hasExpOrIfStatementException = this.hasExpOrIfStatementException(ifStatement.getThenExpOrIfStatement());
    if (_hasExpOrIfStatementException) {
      return true;
    }
    boolean _hasExpOrIfStatementException_1 = this.hasExpOrIfStatementException(ifStatement.getElseExpOrIfStatement());
    if (_hasExpOrIfStatementException_1) {
      return true;
    }
    return false;
  }
  
  public boolean hasExpOrIfStatementException(final ExpOrIfStatement expOrIfStatement) {
    if ((expOrIfStatement == null)) {
      return false;
    }
    OutputExpression _outputExpression = expOrIfStatement.getOutputExpression();
    boolean _tripleNotEquals = (_outputExpression != null);
    if (_tripleNotEquals) {
      OutputExpression _outputExpression_1 = expOrIfStatement.getOutputExpression();
      if ((_outputExpression_1 instanceof ExceptionImpl)) {
        return true;
      }
    }
    IfStatement _ifStatement = expOrIfStatement.getIfStatement();
    boolean _tripleNotEquals_1 = (_ifStatement != null);
    if (_tripleNotEquals_1) {
      boolean _hasIfStatementException = this.hasIfStatementException(expOrIfStatement.getIfStatement());
      if (_hasIfStatementException) {
        return true;
      }
    }
    return false;
  }
  
  public String getBoolExpressionListAsString(final EList<BoolExpression> boolExpressionList) {
    String str = "";
    for (int index = 0; (index < boolExpressionList.size()); index++) {
      {
        BoolExpression boolExpression = boolExpressionList.get(index);
        if ((0 < index)) {
          EObject _eContainer = boolExpression.eContainer();
          String sign = ((IfStatementImpl) _eContainer).getSign().get((index - 1));
          str = (((str + " ") + sign) + " ");
        }
        String _boolExpressionAsString = this.getBoolExpressionAsString(boolExpression);
        String _plus = (str + _boolExpressionAsString);
        str = _plus;
      }
    }
    return str;
  }
  
  public String getBoolExpressionAsString(final BoolExpression boolExpression) {
    String str = this.getLiteralValueAsString(boolExpression.getLiteralLeft());
    Literal _literalRight = boolExpression.getLiteralRight();
    boolean _tripleNotEquals = (_literalRight != null);
    if (_tripleNotEquals) {
      String _sign = boolExpression.getSign();
      String _plus = ((str + " ") + _sign);
      String _plus_1 = (_plus + " ");
      String _some = this.getSome(boolExpression, str);
      String _plus_2 = (_plus_1 + _some);
      String _literalValueAsString = this.getLiteralValueAsString(boolExpression.getLiteralRight());
      String _plus_3 = (_plus_2 + _literalValueAsString);
      str = _plus_3;
    }
    return str;
  }
  
  public String getSome(final BoolExpression boolExpression, final String paramName) {
    String str = "";
    if ((((boolExpression.getLiteralRight() != null) && 
      (boolExpression.getLiteralRight().getPrimary() != null)) && 
      (boolExpression.getLiteralRight().getPrimary() instanceof Null))) {
      return str;
    }
    DefFunction defFunction = this.getDefFunction(boolExpression);
    EList<InputParam> inputParams = defFunction.getInputParams();
    for (final InputParam inputParam : inputParams) {
      boolean _equals = inputParam.getName().equals(paramName);
      if (_equals) {
        String dataTypeName = this.convertDataTypeToPrimitive(inputParam.getInputDataType());
        boolean _endsWith = dataTypeName.endsWith("Opt");
        if (_endsWith) {
          str = "Something ";
        }
        return str;
      }
    }
    return str;
  }
  
  public String nameToOcaml(final String name) {
    String _lowerCase = name.substring(0, 1).toLowerCase();
    String _substring = name.substring(1);
    String str = (_lowerCase + _substring);
    str = str.replace(".", "_");
    return str;
  }
  
  public String getFunctionParams(final EList<InputParam> inputParams) {
    String str = "";
    for (int index = 0; (index < inputParams.size()); index++) {
      String _name = inputParams.get(index).getName();
      String _plus = ((str + " (") + _name);
      String _plus_1 = (_plus + ":");
      String _convertDataTypeToOption = this.convertDataTypeToOption(inputParams.get(index).getInputDataType());
      String _plus_2 = (_plus_1 + _convertDataTypeToOption);
      String _plus_3 = (_plus_2 + ")");
      str = _plus_3;
    }
    return str;
  }
  
  public String buildPrepToJson_DEL_ME(final DefFunction defFunction) {
    EList<InputParam> inputParams = defFunction.getInputParams();
    String comma = "";
    String _nameToOcaml = this.nameToOcaml(defFunction.getName());
    String _plus = ("let prep_" + _nameToOcaml);
    String _plus_1 = (_plus + " ");
    String _functionParams = this.getFunctionParams(inputParams);
    String _plus_2 = (_plus_1 + _functionParams);
    String str = (_plus_2 + " = ");
    str = (str + "[");
    for (int index = 0; (index < inputParams.size()); index++) {
      {
        String _name = inputParams.get(index).getName();
        String _plus_3 = (((str + comma) + " (\"") + _name);
        String _plus_4 = (_plus_3 + "\", ");
        String _convertDataTypeToJsonType = this.convertDataTypeToJsonType(inputParams.get(index).getInputDataType());
        String _plus_5 = (_plus_4 + _convertDataTypeToJsonType);
        String _plus_6 = (_plus_5 + " ");
        String _name_1 = inputParams.get(index).getName();
        String _plus_7 = (_plus_6 + _name_1);
        String _plus_8 = (_plus_7 + ")");
        str = _plus_8;
        comma = "; ";
      }
    }
    str = (str + "]");
    return str;
  }
  
  public String convertDataTypeToJsonType(final DataType dataType) {
    String dataTypeOut = null;
    if (((dataType.getBoolean() != null) || (dataType.getBooleanObj() != null))) {
      dataTypeOut = "`Bool";
    } else {
      if (((((((dataType.getShort() != null) || (dataType.getShortObj() != null)) || 
        (dataType.getInt() != null)) || (dataType.getIntObj() != null)) || 
        (dataType.getLong() != null)) || (dataType.getLongObj() != null))) {
        dataTypeOut = "`Int";
      } else {
        if (((((dataType.getFloat() != null) || (dataType.getFloatObj() != null)) || 
          (dataType.getDouble() != null)) || (dataType.getDoubleObj() != null))) {
          dataTypeOut = "`Float";
        } else {
          String _string = dataType.getString();
          boolean _tripleNotEquals = (_string != null);
          if (_tripleNotEquals) {
            dataTypeOut = "`String";
          } else {
            DefDataType _defDataType = dataType.getDefDataType();
            boolean _tripleNotEquals_1 = (_defDataType != null);
            if (_tripleNotEquals_1) {
              dataTypeOut = "`NotDoneYet";
            }
          }
        }
      }
    }
    return dataTypeOut;
  }
}
