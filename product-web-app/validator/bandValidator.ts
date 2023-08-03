interface Employee {
    fname: string;
    lname: string;
    salary: number;
    bankNo: string;
    nin: string;
  }
  
  export function validateBand(band: Band): string | null {
    if (isNaN(band.salary)) {
      return "Salary must be a number";
    }
  
    if (band.salary < 20000) {
      return "Salary must be at least £20,000";
    }
  
    if (band.bankNo.length < 8) {
      return "Bank number must be at least 8 characters";
    }
  
  
    return null;
  }
  