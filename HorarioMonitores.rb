#Class HorarioMonitores
    arr = []
    puts "Ingrese datos"
    puts 'Escriba "fin" para terminar'
    loop do
      arr = gets.chomp
      #arr << nextline
      if arr == ""
        arr.size == 0
      end
      break if arr == "fin"
      break if arr == ""
      break if arr == nil
    end

    if arr.size == 0
      puts "No puede estar vacío"
    else if arr.size > 1
      puts "Muchos argumentos"
    end
    end
#end
