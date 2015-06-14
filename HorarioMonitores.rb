#Class HorarioMonitores
    arr = []
    puts "Ingrese datos"
    puts 'Escriba "fin" para terminar'
    loop do
      nextline = gets.chomp
      arr << nextline
      break if nextline == "fin"
      break if nextline == ""
    end

    if arr.size == 0
      puts "No puede estar vacío"
    else if arr.size > 1
      puts "Muchos argumentos"
    end
    end
#end
